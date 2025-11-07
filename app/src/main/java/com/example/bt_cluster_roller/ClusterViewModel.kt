package com.example.bt_cluster_roller

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

/**
 * ViewModel to hold the state and business logic for the Cluster Roller.
 */
class ClusterViewModel : ViewModel() {

    // --- UI State ---

    // Dropdown options
    val arcOptions = mapOf("F" to "Front/Rear", "R" to "Right", "L" to "Left")
    val shotCountOptions = Constants.CLUSTER_TABLES_DICT.keys.sorted()

    // Selected values from dropdowns
    var selectedArc = mutableStateOf(arcOptions.keys.first())
    var selectedShotCount = mutableStateOf(shotCountOptions.first())

    // Text field inputs
    var damagePerShot = mutableStateOf("1")
    var groupingSize = mutableStateOf("5")
    var clusterModifier = mutableStateOf("0")

    // Output result text
    private val _resultText = MutableStateFlow("Welcome! Enter values and roll clusters.")
    val resultText: StateFlow<String> = _resultText.asStateFlow()

    // --- Business Logic ---

    /**
     * Main function to perform the cluster roll calculation.
     * Ported from `roll_clusters` in cluster_roller.py
     */
    fun calculateClusters() {
        // 1. Get and validate inputs
        val arc = selectedArc.value
        val shots = selectedShotCount.value
        val dmg = damagePerShot.value.toIntOrNull()
        val clst = groupingSize.value.toIntOrNull()
        val mod = clusterModifier.value.toIntOrNull()

        if (dmg == null || clst == null || mod == null || clst == 0) {
            _resultText.value = "Error: Please enter valid numbers for all fields. Grouping size cannot be zero."
            return
        }

        // 2. Roll for cluster hits
        val clstRoll = Random.nextInt(1, 7) + Random.nextInt(1, 7) + mod
        val clampedRoll = clstRoll.coerceIn(2, 12) // Clamp roll between 2 and 12

        val clusterTable = Constants.CLUSTER_TABLES_DICT[shots]
        if (clusterTable == null) {
            _resultText.value = "Error: No cluster table found for shot count $shots."
            return
        }

        val hitCount = clusterTable[clampedRoll] ?: 0
        val totalDmg = hitCount * dmg

        val resultBuilder = StringBuilder()
        resultBuilder.appendLine("Cluster Roll (2d6 + $mod): $clstRoll -> $clampedRoll")
        resultBuilder.appendLine("Result: $hitCount Hits")
        resultBuilder.appendLine("Total Damage: $totalDmg ($hitCount hits * $dmg dmg/shot)")
        resultBuilder.appendLine("---")

        // 3. Distribute damage
        val hitsDict = mutableMapOf(
            "RA" to 0, "RL" to 0, "RT" to 0,
            "LA" to 0, "LL" to 0, "LT" to 0,
            "CT" to 0, "HD" to 0, "TAC" to 0
        )

        val numGroupings = totalDmg / clst
        val remainderDmg = totalDmg % clst

        for (i in 1..numGroupings) {
            val hitLoc = rollHitLocation(arc)
            hitsDict[hitLoc] = (hitsDict[hitLoc] ?: 0) + 1
        }

        var remainderLoc = ""
        if (remainderDmg > 0) {
            remainderLoc = rollHitLocation(arc)
        }

        // 4. Format and display results
        hitsDict.filter { it.value > 0 }.forEach { (loc, count) ->
            resultBuilder.appendLine("$count Grouping(s) of $clst dmg to $loc")
        }

        if (remainderLoc.isNotBlank()) {
            resultBuilder.appendLine("$remainderDmg Remaining Damage to $remainderLoc")
        }

        if (resultBuilder.lines().count() <= 4) {
            resultBuilder.appendLine("No groupings assigned (total damage was less than grouping size).")
        }

        _resultText.value = resultBuilder.toString()
    }

    /**
     * Rolls 2d6 and determines the hit location based on the arc.
     * Ported from `roll_hit` in cluster_roller.py
     */
    private fun rollHitLocation(arc: String): String {
        val hitRoll = Random.nextInt(1, 7) + Random.nextInt(1, 7)

        val hitTable = when (arc) {
            "F" -> Constants.FRONT_HIT_DICT
            "R" -> Constants.RIGHT_HIT_DICT
            "L" -> Constants.LEFT_HIT_DICT
            else -> {
                // This should not happen given the dropdown
                return "ERROR_ARC"
            }
        }

        return hitTable[hitRoll] ?: "ERROR_ROLL"
    }
}