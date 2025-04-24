//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

fun main() {
    val bing = makeBing(
        {
            this.name("빙빙")
            this.money(100)
            this.job("백수")
            this.house("무주택")
            this.likes {
                food("딸기")
                food("메롱")
            }
        }
    )
    println(bing.name)
    println(bing.house)
}

fun makeBing(builder: BingBuilder.() -> Unit): Bing {
    return BingBuilder().apply(builder).build()
}

class FavoriteBuilder {
    private val food: MutableList<String> = mutableListOf()
    private val hobby: MutableList<String> = mutableListOf()

    fun food(value: String) {
        food.add(value)
    }

    fun hobby(value: String) {
        hobby.add(value)
    }

    fun build() = Favorites(food, hobby)
}

data class Favorites(
    val food: List<String> = emptyList(),
    val hobby: List<String> = emptyList(),
)

class BingBuilder {
    private lateinit var name: String
    private var money: Long = 0
    private var job: String? = null
    private var house: String? = null
    private var favorites: Favorites? = null

    fun likes(block: FavoriteBuilder.() -> Unit) {
        this.favorites = FavoriteBuilder().apply(block).build()
    }

    fun name(name: String) {
        this.name = name
    }

    fun money(money: Long) {
        this.money = money
    }

    fun job(job: String) {
        this.job = job
    }

    fun house(house: String) {
        this.house = house
    }

    fun build(): Bing = Bing(
        name = name,
        money = money,
        job = job,
        house = house,
    )
}

data class Bing(
    val name: String,
    val money: Long,
    val job: String?,
    val house: String?,
)
