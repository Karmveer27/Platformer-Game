package Characters;

public class Constants {
    public static class PlayerStance {
        public static final int IDLE = 0;
        public static final int RUN = 1;
        public static final int ATTACK = 2;
        public static final int ATTACK_EXTRA = 998;
        public static final int CLIMB = 997;
        public static final int JUMP = 996;
        public static final int HIGH_JUMP = 995;
        public static final int HURT = 994;
        public static final int PUSH = 993;
        public static final int RUN_ATTACK = 992;
        public static final int WALK = 991;
        public static final int WALK_ATTACK = 939;
        public static final int DEATH = 929;


        public static int getAnimationAmount(int stance) {
            switch (stance) {
                case IDLE, HIGH_JUMP:
                    return 12;
                case ATTACK, CLIMB, HURT, PUSH:
                    return 4;
                case ATTACK_EXTRA, RUN, RUN_ATTACK:
                    return 8;
                case JUMP:
                    return 7;
                case WALK, WALK_ATTACK:
                    return 6;
                case DEATH:
                    return 10;
                default:
                    return 1;



            }
        }

    }

    public class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;

    }

}

