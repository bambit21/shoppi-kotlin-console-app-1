package screen

/*
Step 1. 장바구니에 추가한 상품 관리
Step 2. 사용자 입력값 요청 처리 공통화
Step 3. 프로젝트 전역에서 참조하는 상수
 */

class ShoppingCategory {

    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요.")

        var selectedCategory = readLine()
        // readLine() 은 nullable String 타입이다.
        // 즉, 입력값을 읽어들이지 못하면 null 이 될 수 있다.
        // 또한 사용자는 아무것도 입력하지않고 화이트 스페이스만 입력할수도 있다.
        // 이를 모두 대응하는 방법은 사용자가 어떤 값이든 무언가를 입력할 때까지 재요청하는 것이다.
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요.")
            selectedCategory = readLine()
        }

        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        showCategories()
    }
}