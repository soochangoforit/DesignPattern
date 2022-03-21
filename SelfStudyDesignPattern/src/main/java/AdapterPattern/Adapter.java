
package AdapterPattern;

// 원래 알고리즘은 Double 형태이지만 Float으로 변동하기 위해 새로운 interface 생성
// 미리 주어진 함수를 요구사항에 맞춰 변경하는것을 담당
public interface Adapter {
    
    public Float twiceOf(Float f);
    public Float halfOf(Float f);
    
}
