package creational_patterns

data class FoodOrder(
    private val brad: String?,
    private val meat: String?,
    private val fish: String?,
    private val delivery: String?
) {
    class Builder() {
        private var bread: String? = null
        private var meat: String? = null
        private var fish: String? = null
        private var delivery: String? = null

        fun getBread(bread: String) = apply { this.bread = bread }
        fun getMeat(meat: String) = apply { this.meat = meat }
        fun getFish(fish: String) = apply { this.fish = fish }
        fun selectDelivery(delivery: String) = apply { this.delivery = delivery }

        fun build() = FoodOrder(bread, meat, fish, delivery)
    }
}

fun main() {
    val order = FoodOrder.Builder()
        .getBread("багет")
        .getFish("сайра")
        .getMeat("докторская")
        .build()

    println(order)
}