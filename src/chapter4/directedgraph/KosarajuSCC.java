package chapter4.directedgraph;

/**
 * @author: bangxin.wang
 * @date: 2024/12/24 21:39
 */
public class KosarajuSCC implements SCC{


    @Override
    public boolean stronglyConnected(int v, int w) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int id(int v) {
        return 0;
    }
}
