package io.github.tunguyen227

expect abstract class PlatformContext

expect object Platform {
    val name: String

    object Build {
        val sdk: Float
    }
}

enum class OSystem(val system: String) {
    ANDROID("Android"),
    IOS("iOS")
}

enum class AndroidVersions(val code: Float) {
    CUR_DEVELOPMENT(10000f),
    BASE(1f),
    BASE_1_1(2f),
    CUPCAKE(3f),
    DONUT(4f),
    ECLAIR(5f),
    ECLAIR_0_1(6f),
    ECLAIR_MR1(7f),
    FROYO(8f),
    GINGERBREAD(9f),
    GINGERBREAD_MR1(10f),
    HONEYCOMB(11f),
    HONEYCOMB_MR1(12f),
    HONEYCOMB_MR2(13f),
    ICE_CREAM_SANDWICH(14f),
    ICE_CREAM_SANDWICH_MR1(15f),
    JELLY_BEAN(16f),
    JELLY_BEAN_MR1(17f),
    KITKAT(19f),
    KITKAT_WATCH(20f),
    L(21f),
    LOLLIPOP(21f),
    LOLLIPOP_MR1(22f),
    M(23f),
    N(24f),
    N_MR1(25f),
    O(26f),
    O_MR1(27f),
    P(28f),
    Q(29f),
    R(30f),
    S_V2(32f),
    TIRAMISU(33f),
    UPSIDE_DOWN_CAKE(34f),
    VANILLA_ICE_CREAM(35f);

    companion object {
        fun fromFloat(value: Float): AndroidVersions? {
            return entries.find { it.code == value }
        }
    }
}

enum class IOSVersion(val value: Float) {
    VERSION_1(1.15f),
    VERSION_2(2.21f),
    VERSION_3(3.22f),
    VERSION_4(4.35f),
    VERSION_5(5.11f),
    VERSION_6(6.16f),
    VERSION_7(7.12f),
    VERSION_8(8.41f),
    VERSION_9(9.36f),
    VERSION_10(10.34f),
    VERSION_11(11.41f),
    VERSION_12(12.57f),
    VERSION_13(13.7f),
    VERSION_14(14.81f),
    VERSION_15(15.83f),
    VERSION_16(16.710f),
    VERSION_17(17.72f),
    VERSION_18(18.32f);

    companion object {
        fun fromFloat(value: Float): IOSVersion? {
            return entries.find { it.value == value }
        }
    }
}