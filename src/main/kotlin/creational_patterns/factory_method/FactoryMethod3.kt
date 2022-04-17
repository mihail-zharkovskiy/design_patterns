package creational_patterns.factory_method

sealed class Country {
    object Spain : Country()
    object Greece : Country()
    object Canada : Country()
}

class Currency(
    val code: String
)

object CurrencyFactory {
    //factory method
    fun currencyForCountry(country: Country): Currency = when (country) {
        is Country.Greece -> Currency("EUR")
        is Country.Spain -> Currency("EUR")
        is Country.Canada -> Currency("CAD")
    }
}

fun main() {
    val currencyCanada = CurrencyFactory.currencyForCountry(Country.Greece).code
    println("Canad currency: $currencyCanada")
}