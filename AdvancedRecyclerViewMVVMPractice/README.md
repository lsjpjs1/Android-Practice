
![AdvancedRecyclerViewMVVM](https://user-images.githubusercontent.com/29132574/124370221-eab43c00-dcaf-11eb-8b5a-9b47d563a1ae.gif)

# 한계
ArrayList를 LiveData로 사용 시 ArrayList의 개별 요소가 바뀌는 것은 Observe 하지 못함
그래서 ArrayList를 통으로 수정하고 다시 그 전체 ArrayList를 LiveData.value에 넣어줘야 한다
그런데 이렇게 하면 아래 영상처럼 내가 원하는 부분만 바뀌는게 아니라 뷰가 통채로 리로딩됨
![AdvancedRecyclerViewMVVM_Limitation](https://user-images.githubusercontent.com/29132574/124370340-7d090f80-dcb1-11eb-8e07-772d1533b6f1.gif)


