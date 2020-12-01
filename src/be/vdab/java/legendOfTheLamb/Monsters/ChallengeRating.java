package be.vdab.java.legendOfTheLamb.Monsters;

public enum ChallengeRating {
    CR0(10),
    CR1(25),
    CR2(50),
    CR3(100),
    CR4(150),
    CR5(450),
    CR6(800),
    CR7(2000);

    int exp=0;

    ChallengeRating(int exp){
        this.exp=exp;
    }

    public int getExp() {
        return exp;
    }
}
