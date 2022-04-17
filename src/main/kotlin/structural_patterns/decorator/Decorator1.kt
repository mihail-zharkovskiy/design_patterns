package structural_patterns.decorator

/**
 * Decorator он же Wrapper
 * 1) Представим, что в MapFragment очень много кода,
 * львиную долю этого кода занимает работа с MapView...
 * и чтобы сократить объем кода во фрагменте, создадим декоратор-обертку для класса MapView.
 * 2) Также этот патер можно использовать для расширения возможностей класса
 * вместо наследования.
 * 3) И по хорошему интерфейс декоратора-обертки должен быть таким же
 * как и у тех компонентов которые он принимает внутрь себя
 **/
class MapFragment() {
    private val mapView = MapView()
    private val mapViewWrapper = MapViewWrapper(mapView)

    fun renderUserOnMap() = mapViewWrapper.drawUserOnMap()
}

/**
 * Декоратор-обертка создан при помощи агрегации
 * но также можно использовать и композицию.
 * (даа,нужно передавать в конструктор абстракцию вместо конкретной реализации)
 * **/
class MapViewWrapper(private val mapView: MapView) {
    fun drawUserOnMap() {
        mapView.calculateCoordinates()
        mapView.prepareData()
        mapView.renderUserOnMap()
    }
}

class MapView() {
    fun calculateCoordinates() = println("расчет координат")
    fun prepareData() = println("подготавливаем данные для отрисовки карты")
    fun renderUserOnMap() = println("рисуем пользователя на карте")
}

fun main() {
    val mapFragment = MapFragment()
    mapFragment.renderUserOnMap()
}

