# Sliding Window template code
```java
static int max_sub_array(int[] arr, int k){
    int window_sum = 0, max_sum = 0, window_start = 0;
    
    for(int window_end = 0; window_end < arr.length; window_end++){
        window_sum += arr[window_end];  // 슬라이딩 인덱스 범위 요소 합산
        
        // 슬라이딩 윈도우의 범위가 k 보다 커진 경우
        if(window_end - windowStart >= (k-1)){
            max_sum = Math.max(max_sum, window_sum);
            window_sum -= arr[window_start++]; // 슬라이딩 윈도우 범위를 벗어난 요소를 합계에서 제거
        }
    }
    return max_sum
}
```