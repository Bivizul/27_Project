package aaa.bivizul.a27project.navigation

sealed class Destination(val route: String) {
    object Main : Destination("main")
    object Leveges : Destination("leveges")
    object Leverages : Destination("leverages")
    object LeveragesDetail : Destination("leverages_detail")
    object LeveragesItemId : Destination("leverages_item_id")
}