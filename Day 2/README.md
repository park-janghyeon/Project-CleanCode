## Day 2

### Seller Class Implementation

Seller(판매자) 클래스를 만들어주세요.<br/>
판매자는 다음과 같은 3가지 행위들을 할 수 있으며, 이 3가지 각각을 어떤 함수를 통해 실행할 수 있어야 합니다.

- 재고현황(하단 안내 참고)에서 특정 물품(String)을 탐색하고 수량(Number)을 반환합니다.
- 가격표(하단 안내 참고)에서 특정 물품(String)을 탐색하고, 그것의 가격(Number)를 반환합니다.
- 구매자의 구매목록(히딘 안내 침고)을 매개변수로 전달받고, 구매 가능한 물품들의 총 가격을 반환합니다.

### Bonus
- Bonus 내용들은 구현해도 좋고, 하지 않아도 좋습니다. 한번 고민해보세요!
- 물품의 재고가 5개 이하인 물품들은 10% 할인 행사를 한다고 합니다! 구매자의 구매 함수 내에 이를 적용해 구현해보세요.
- 재고가 늘어납니다! 특정 물품의 수량을 늘릴 수 있는 함수를 구현해보세요.

### 안내 사항
- 재고현황, 가격표, 구매목록의 경우, Key-Value 형식으로 저장되는 자료형입니다. CPP의 `map` 혹은 Python의 `dictionary`, Java의 `Hashmap` 자료형 등을 통해 구현합니다.
- 이 때, 재고현황의 경우는 물품의 이름과 수량을 포함하며, 가격표는 물품의 이름과 가격, 구매목록은 물품의 이름과 구매수량을 각각 자식 요소로 갖습니다.
- 아래 예시를 참고하여, 각각의 자료를 클래스 내에서 접근 가능한 변수로 선언한 뒤, 이를 이용해 각 함수를 구현해주세요.

CPP
```cpp
map<string, long long> prices;
prices["ABCD"] = 1234;
prices["QWER"] = 5678;
```
Java
```java
HashMap<String, long> prices = new HashMap<String, long>();
prices.put("ABCD", 1234);
prices.put("QWER", 5678);
```
Python
```python
price = {"ABCD": 1234, "QWER": 5678}
```