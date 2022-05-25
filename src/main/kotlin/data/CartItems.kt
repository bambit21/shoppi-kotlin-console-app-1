package data

object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()  // 상품의 수량 정보도 저장하기 위해서 map 을 사용한다.
    val products: Map<Product, Int> = mutableProducts

    fun addProduct(product: Product) {
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run {
            mutableProducts[product] = 1
        }
    }
}

/* CartItems 를 object 로 만드는 이유
CartItems 는 프로젝트 전역에서 상품데이터를 저장하는 클래스이므로
항상 같은 값이 유지되어야 하기 때문에 싱글턴 객체로 만드는것이 적합하다.
 */
/*
mutable 타입과 immutable 타입을 같이 사용하고 있는데,
mutable 타입은 private 가시성 접근자를 사용해서 외부에서는 원소를 수정할 수 없도록 제한을 했고
외부에 공개하는 products 는 immutable 타입으로 선언해서 read only 만 가능하도록 제한함.
*/