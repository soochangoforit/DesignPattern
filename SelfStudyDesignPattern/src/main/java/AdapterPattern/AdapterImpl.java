
package AdapterPattern;

// 변경 사항이 있으면 Adapter Interface와 Test를 건들지 않고
// 실제 구현을 담당하는 Impl 안에서만 변경하면 된다.
public class AdapterImpl implements Adapter{
    
    @Override
    public Float twiceOf(Float f) {
        return (float) Math.twoTime(f.doubleValue());
    }

    @Override
    public Float halfOf(Float f) {
        return (float) Math.half(f.doubleValue());
    }
    
}
