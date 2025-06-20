public class Preparat extends Articles {
    
    
    
        private float minuts;

        public Preparat(int codiNumeric, String nom, float  preu, float minuts) {
            super(codiNumeric, nom, preu);
            this.minuts = minuts;
        }

        @Override
        public String toString() {
            return super.toString() + " Temps: " + minuts + "m ";
        }

        @Override
    public float GetCost() {
        return (float) (getPreu() + (minuts*0.5));
    }


}
