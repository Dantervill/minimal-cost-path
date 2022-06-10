public abstract class Character {
    protected int S;
    protected int W;
    protected int T;
    protected int P;

    protected Character(int S, int W, int T, int P) {
        this.S = S;
        this.W = W;
        this.T = T;
        this.P = P;
    }

    public int getS() {
        return S;
    }

    public int getW() {
        return W;
    }

    public int getT() {
        return T;
    }

    public int getP() {
        return P;
    }
}
