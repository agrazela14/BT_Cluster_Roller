package com.example.bt_cluster_roller

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * The main UI screen for the Cluster Roller app, built with Jetpack Compose.
 */
@Composable
fun ClusterScreen(vm: ClusterViewModel = viewModel()) {
    val resultText by vm.resultText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Make column scrollable
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Cluster Roller", style = MaterialTheme.typography.headlineMedium)

        // --- Inputs ---

        // Unit Type Dropdown
        DropdownInput(
            label             = "Unit Type",
            options           = vm.unitTypeOptions,
            selected          = vm.selectedUnitType.value,
            onSelectionChange = { vm.selectedUnitType.value = it }
        )

        // Arc Dropdown
        DropdownInput(
            label             = "Hitting Arc",
            options           = vm.arcOptions,
            selected          = vm.selectedArc.value,
            onSelectionChange = { vm.selectedArc.value = it }
        )

        // Shot Count Dropdown
        DropdownInput(
            label = "Shot Count",
            // Convert Int keys to String keys for the display map
            options = vm.shotCountOptions,
            selected = vm.selectedShotCount.value,
            onSelectionChange = { vm.selectedShotCount.value = it }
        )

        // Shot Damage Dropdown
        DropdownInput(
            label = "Shot Damage",
            // Convert Int keys to String keys for the display map
            options = vm.shotDamageOptions,
            selected = vm.selectedShotDamage.value,
            onSelectionChange = { vm.selectedShotDamage.value = it }
        )

        // Grouping Size Dropdown
        DropdownInput(
            label = "Grouping Size",
            // Convert Int keys to String keys for the display map
            options = vm.groupingOptions,
            selected = vm.selectedGrouping.value,
            onSelectionChange = { vm.selectedGrouping.value = it }
        )

        // Cluster Modifier Dropdown
        DropdownInput(
            label = "Grouping Size",
            // Convert Int keys to String keys for the display map
            options = vm.modifierOptions,
            selected = vm.selectedModifier.value,
            onSelectionChange = { vm.selectedModifier.value = it }
        )

        // --- Actions ---
        Button(
            onClick = { vm.calculateClusters() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Roll Clusters")
        }

        // --- Results ---
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text("Results", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = resultText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 150.dp)
        )
    }
}

/**
 * A reusable Composable for a dropdown menu (ExposedDropdownMenuBox).
 * @param options A Set of values for the dropdown
 * and the value is the text to be displayed (e.g., "Front/Rear").
 * @param selected The currently selected value.
 * @param onSelectionChange Lambda called when a new key is selected.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DropdownInput(
    label: String,
    options: Set<T>,
    selected: T,
    onSelectionChange: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedDisplayValue = selected?.toString() ?: "Select"

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDisplayValue,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { value ->
                DropdownMenuItem(
                    text = { Text(value.toString()) },
                    onClick = {
                        onSelectionChange(value)
                        expanded = false
                    }
                )
            }
        }
    }
}