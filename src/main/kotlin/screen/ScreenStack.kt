package screen

object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen) {
        screenStack.add(screen)
    }

    fun pop() {
        screenStack.removeLastOrNull()
    }

    fun peek(): Screen? {
        return screenStack.lastOrNull()
    }
    // lastOrNull() :  mutableList 에 데이터가 존재하지 않을 때는 index 정보를 조회하지않고 null 을 반환하여 runtime error 를 발생시키지 않는다.
}
/*
ScreenStack 또한 프로젝트 전역에서 화면 이동을 관리하는 싱글톤 객체여도 적합할거라고 생각.
 */

sealed class Screen
/*
ScreenStack 이 관리하는 Screen 타입을 sealed class 로 추가.
지금까지 추가했던 모든 화면들이 sealed class 의 Screen 클래스의 subclass 가 될것임.
 */
/*
Screen Stack 이 화면이동을 관리할 수 있도록 Screen 의 subclass 를 선언해야한다.
지금까지 추가했던 모든 화면들(Shopping Cart, Category, Home, Product.kt) 이 Screen 을 상속받으면 Screen 의 subclass 가 된다.
이제 모든 화면의 이동을 ScreenStack 에서 관리할 수 있게 된다.
 */