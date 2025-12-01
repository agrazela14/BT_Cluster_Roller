package com.example.bt_cluster_roller

/**
 * Port of constants.py
 *
 * This object holds all the constant maps for hit locations and cluster tables.
 */
object Constants {

    // MECH Hit Location Dictionaries
    val MECH_FRONT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "RA",
        4 to "RA",
        5 to "RL",
        6 to "RT",
        7 to "CT",
        8 to "LT",
        9 to "LL",
        10 to "LA",
        11 to "LA",
        12 to "HD"
    )

    val MECH_REAR_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "RA",
        4 to "RA",
        5 to "RL",
        6 to "RRT",
        7 to "RCT",
        8 to "RLT",
        9 to "LL",
        10 to "LA",
        11 to "LA",
        12 to "HD"
    )

    val MECH_RIGHT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "RL",
        4 to "RA",
        5 to "RA",
        6 to "RL",
        7 to "RT",
        8 to "CT",
        9 to "LT",
        10 to "LA",
        11 to "LL",
        12 to "HD"
    )

    val MECH_LEFT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "LL",
        4 to "LA",
        5 to "LA",
        6 to "LL",
        7 to "LT",
        8 to "CT",
        9 to "RT",
        10 to "RA",
        11 to "RL",
        12 to "HD"
    )

    // QUAD Hit Location Dictionaries
    val QUAD_FRONT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "FRL",
        4 to "FRL",
        5 to "RRL",
        6 to "RT",
        7 to "CT",
        8 to "LT",
        9 to "RLL",
        10 to "FLL",
        11 to "FLL",
        12 to "HD"
    )

    val QUAD_REAR_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "FRL",
        4 to "FRL",
        5 to "RRL",
        6 to "RRT",
        7 to "RCT",
        8 to "RLT",
        9 to "RLL",
        10 to "FLL",
        11 to "FLL",
        12 to "HD"
    )

    val QUAD_RIGHT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "RRL",
        4 to "FRL",
        5 to "FRL",
        6 to "RRL",
        7 to "RT",
        8 to "CT",
        9 to "LT",
        10 to "FLL",
        11 to "RLL",
        12 to "HD"
    )

    val QUAD_LEFT_HIT: Map<Int, String> = mapOf(
        2 to "TAC",
        3 to "RLL",
        4 to "FLL",
        5 to "FLL",
        6 to "RLL",
        7 to "LT",
        8 to "CT",
        9 to "RT",
        10 to "FRL",
        11 to "RRL",
        12 to "HD"
    )

    // VEHICLE Hit Location Dictionaries
    val VEHICLE_FRONT_HIT: Map<Int, String> = mapOf(
        2 to "FR TAC",
        3 to "FR MTV",
        4 to "FR MTV",
        5 to "RS MTV",
        6 to "FR",
        7 to "FR",
        8 to "FR",
        9 to "LS MTV",
        10 to "TUR",
        11 to "TUR",
        12 to "TUR TAC"
    )

    val VEHICLE_REAR_HIT: Map<Int, String> = mapOf(
        2 to "RR TAC",
        3 to "RR MTV",
        4 to "RR MTV",
        5 to "LS MTV",
        6 to "RR",
        7 to "RR",
        8 to "RR",
        9 to "RS MTV",
        10 to "TUR",
        11 to "TUR",
        12 to "TUR TAC"
    )

    val VEHICLE_RIGHT_HIT: Map<Int, String> = mapOf(
        2 to "RS TAC",
        3 to "RS MTV",
        4 to "RS MTV",
        5 to "FR MTV",
        6 to "RS",
        7 to "RS",
        8 to "RS TAC",
        9 to "RR MTV",
        10 to "TUR",
        11 to "TUR",
        12 to "TUR TAC"
    )

    val VEHICLE_LEFT_HIT: Map<Int, String> = mapOf(
        2 to "LS TAC",
        3 to "LS MTV",
        4 to "LS MTV",
        5 to "FR MTV",
        6 to "LS",
        7 to "LS",
        8 to "LS TAC",
        9 to "RR MTV",
        10 to "TUR",
        11 to "TUR",
        12 to "TUR TAC"
    )
    // Cluster Table Dictionaries
    private val TWO_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1, 7 to 1, 8 to 2, 9 to 2, 10 to 2, 11 to 2, 12 to 2
    )
    private val THREE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 1, 3 to 1, 4 to 1, 5 to 2, 6 to 2, 7 to 2, 8 to 2, 9 to 2, 10 to 3, 11 to 3, 12 to 3
    )
    private val FOUR_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 1, 3 to 2, 4 to 2, 5 to 2, 6 to 2, 7 to 3, 8 to 3, 9 to 3, 10 to 3, 11 to 4, 12 to 4
    )
    private val FIVE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 1, 3 to 2, 4 to 2, 5 to 3, 6 to 3, 7 to 3, 8 to 3, 9 to 4, 10 to 4, 11 to 5, 12 to 5
    )
    private val SIX_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 2, 3 to 2, 4 to 3, 5 to 3, 6 to 4, 7 to 4, 8 to 4, 9 to 5, 10 to 5, 11 to 6, 12 to 6
    )
    private val SEVEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 2, 3 to 2, 4 to 3, 5 to 4, 6 to 4, 7 to 4, 8 to 4, 9 to 6, 10 to 6, 11 to 7, 12 to 7
    )
    private val EIGHT_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 3, 3 to 3, 4 to 4, 5 to 4, 6 to 5, 7 to 5, 8 to 5, 9 to 6, 10 to 6, 11 to 8, 12 to 8
    )
    private val NINE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 3, 3 to 3, 4 to 4, 5 to 5, 6 to 5, 7 to 5, 8 to 5, 9 to 7, 10 to 7, 11 to 9, 12 to 9
    )
    private val TEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 3, 3 to 3, 4 to 4, 5 to 6, 6 to 6, 7 to 6, 8 to 6, 9 to 8, 10 to 8, 11 to 10, 12 to 10
    )
    private val ELEVEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 4, 3 to 4, 4 to 5, 5 to 7, 6 to 7, 7 to 7, 8 to 7, 9 to 9, 10 to 9, 11 to 11, 12 to 11
    )
    private val TWELVE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 4, 3 to 4, 4 to 5, 5 to 8, 6 to 8, 7 to 8, 8 to 8, 9 to 10, 10 to 10, 11 to 12, 12 to 12
    )
    private val THIRTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 4, 3 to 4, 4 to 5, 5 to 8, 6 to 8, 7 to 8, 8 to 8, 9 to 11, 10 to 11, 11 to 13, 12 to 13
    )
    private val FOURTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 5, 3 to 5, 4 to 6, 5 to 9, 6 to 9, 7 to 9, 8 to 9, 9 to 11, 10 to 11, 11 to 14, 12 to 14
    )
    private val FIFTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 5, 3 to 5, 4 to 6, 5 to 9, 6 to 9, 7 to 9, 8 to 9, 9 to 12, 10 to 12, 11 to 15, 12 to 15
    )
    private val SIXTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 5, 3 to 5, 4 to 7, 5 to 10, 6 to 10, 7 to 10, 8 to 10, 9 to 13, 10 to 13, 11 to 16, 12 to 16
    )
    private val SEVENTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 5, 3 to 5, 4 to 7, 5 to 10, 6 to 10, 7 to 10, 8 to 10, 9 to 14, 10 to 14, 11 to 17, 12 to 17
    )
    private val EIGHTEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 6, 3 to 6, 4 to 8, 5 to 11, 6 to 11, 7 to 11, 8 to 11, 9 to 14, 10 to 14, 11 to 18, 12 to 18
    )
    private val NINETEEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 6, 3 to 6, 4 to 8, 5 to 11, 6 to 11, 7 to 11, 8 to 11, 9 to 15, 10 to 15, 11 to 19, 12 to 19
    )
    private val TWENTY_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 6, 3 to 6, 4 to 9, 5 to 12, 6 to 12, 7 to 12, 8 to 12, 9 to 16, 10 to 16, 11 to 20, 12 to 20
    )
    private val TWENTYONE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 7, 3 to 7, 4 to 9, 5 to 13, 6 to 13, 7 to 13, 8 to 13, 9 to 17, 10 to 17, 11 to 21, 12 to 21
    )
    private val TWENTYTWO_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 7, 3 to 7, 4 to 9, 5 to 14, 6 to 14, 7 to 14, 8 to 14, 9 to 18, 10 to 18, 11 to 22, 12 to 22
    )
    private val TWENTYTHREE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 7, 3 to 7, 4 to 10, 5 to 15, 6 to 15, 7 to 15, 8 to 15, 9 to 19, 10 to 19, 11 to 23, 12 to 23
    )
    private val TWENTYFOUR_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 8, 3 to 8, 4 to 10, 5 to 16, 6 to 16, 7 to 16, 8 to 16, 9 to 20, 10 to 20, 11 to 24, 12 to 24
    )
    private val TWENTYFIVE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 8, 3 to 8, 4 to 10, 5 to 16, 6 to 16, 7 to 16, 8 to 16, 9 to 21, 10 to 21, 11 to 25, 12 to 25
    )
    private val TWENTYSIX_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 9, 3 to 9, 4 to 11, 5 to 17, 6 to 17, 7 to 17, 8 to 17, 9 to 21, 10 to 21, 11 to 26, 12 to 26
    )
    private val TWENTYSEVEN_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 9, 3 to 9, 4 to 11, 5 to 17, 6 to 17, 7 to 17, 8 to 17, 9 to 22, 10 to 22, 11 to 27, 12 to 27
    )
    private val TWENTYEIGHT_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 9, 3 to 9, 4 to 11, 5 to 17, 6 to 17, 7 to 17, 8 to 17, 9 to 23, 10 to 23, 11 to 28, 12 to 28
    )
    private val TWENTYNINE_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 10, 3 to 10, 4 to 12, 5 to 18, 6 to 18, 7 to 18, 8 to 18, 9 to 23, 10 to 23, 11 to 29, 12 to 29
    )
    private val THIRTY_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 10, 3 to 10, 4 to 12, 5 to 18, 6 to 18, 7 to 18, 8 to 18, 9 to 24, 10 to 24, 11 to 30, 12 to 30
    )
    private val FOURTY_TABLE_DICT: Map<Int, Int> = mapOf(
        2 to 12, 3 to 12, 4 to 18, 5 to 24, 6 to 24, 7 to 24, 8 to 24, 9 to 32, 10 to 32, 11 to 40, 12 to 40
    )

    // Master Dictionary for Mapping The Unit type and Arc to the right Map
    val MASTER_HIT_TABLE_DIRECTORY: Map<Pair<String, String>, Map<Int, String>> = mapOf(
        Pair("Mech", "Front")    to MECH_FRONT_HIT,
        Pair("Mech", "Rear")     to MECH_REAR_HIT,
        Pair("Mech", "Right")    to MECH_RIGHT_HIT,
        Pair("Mech", "Left")     to MECH_LEFT_HIT,
        Pair("Quad", "Front")    to QUAD_FRONT_HIT,
        Pair("Quad", "Rear")     to QUAD_REAR_HIT,
        Pair("Quad", "Right")    to QUAD_RIGHT_HIT,
        Pair("Quad", "Left")     to QUAD_LEFT_HIT,
        Pair("Vehicle", "Front") to VEHICLE_FRONT_HIT,
        Pair("Vehicle", "Rear")  to VEHICLE_REAR_HIT,
        Pair("Vehicle", "Right") to VEHICLE_RIGHT_HIT,
        Pair("Vehicle", "Left")  to VEHICLE_LEFT_HIT
    )
    // Master dictionary mapping shot count (key) to its corresponding cluster table
    val CLUSTER_TABLES_DICT: Map<Int, Map<Int, Int>> = mapOf(
        2 to TWO_TABLE_DICT,
        3 to THREE_TABLE_DICT,
        4 to FOUR_TABLE_DICT,
        5 to FIVE_TABLE_DICT,
        6 to SIX_TABLE_DICT,
        7 to SEVEN_TABLE_DICT,
        8 to EIGHT_TABLE_DICT,
        9 to NINE_TABLE_DICT,
        10 to TEN_TABLE_DICT,
        11 to ELEVEN_TABLE_DICT,
        12 to TWELVE_TABLE_DICT,
        13 to THIRTEEN_TABLE_DICT,
        14 to FOURTEEN_TABLE_DICT,
        15 to FIFTEEN_TABLE_DICT,
        16 to SIXTEEN_TABLE_DICT,
        17 to SEVENTEEN_TABLE_DICT,
        18 to EIGHTEEN_TABLE_DICT,
        19 to NINETEEN_TABLE_DICT,
        20 to TWENTY_TABLE_DICT,
        21 to TWENTYONE_TABLE_DICT,
        22 to TWENTYTWO_TABLE_DICT,
        23 to TWENTYTHREE_TABLE_DICT,
        24 to TWENTYFOUR_TABLE_DICT,
        25 to TWENTYFIVE_TABLE_DICT,
        26 to TWENTYSIX_TABLE_DICT,
        27 to TWENTYSEVEN_TABLE_DICT,
        28 to TWENTYEIGHT_TABLE_DICT,
        29 to TWENTYNINE_TABLE_DICT,
        30 to THIRTY_TABLE_DICT,
        40 to FOURTY_TABLE_DICT
    )
}