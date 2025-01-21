public class SurvivorLeader {

    public static void main(String[] args) {
        SurvivorLeader s = new SurvivorLeader();
    }

    private String transmission = "q2xf1t8r5w3t tm9c5i8l900d5n7heto 3g5t6hgw44y5e7bhty605rh8t5 85ml95ak2k5r7qw5ksp295e5t7p45 o5i3n 6z5n205 9soe5o8hhg5lygtt5dq7th 5 gf34s9o 35j7j5o45k99hg5kyqqcjg5mkpl20z5o629sle5k20sk5k9c5 gh73h qxp25vi8t5i3f2v1q 9x7z6t5l8r9j3o4v5l3l1w 9y5a4d6f7x2c9l5g h8s45ek6";
    public Shelter[] shelters;

    public SurvivorLeader(){
        System.out.println("Goodbye World! Good luck surviving the apocalypse!");
        shelters = new Shelter[40];
        for(int x = 0; x < shelters.length; x++){
            int defenseLevel = (int)(Math.random()*100 + 1);
            int numberOfSupplies = (int)(Math.random()*1000);
            shelters[x] = new Shelter(defenseLevel, numberOfSupplies);
        }
        displayShelters();
        System.out.println("It is " + checkSupplies() + " that two shelters have the same number of supplies.");
        System.out.println("Decoded sentence: " + decipher(transmission));
        newDefense();
        displayShelters();
//        System.out.println(checkDefense());
    }

    public void displayShelters(){
        for(int x = 0; x < shelters.length; x++){
            System.out.print("Shelter[" + x + "]: ");
            shelters[x].printInfo();
        }
    }

    public boolean checkSupplies(){
        boolean check = false;
        for(int x = 0; x < shelters.length; x++){
            for(int i = 0; i < shelters.length; i++){
                if(shelters[x].getNumberOfSupplies() == shelters[i].getNumberOfSupplies() && (x != i)){
                    check = true;
                }
            }
        }
        return check;
    }

    public String decipher(String sample){
        String decoded = "";
        int index = sample.indexOf("5") + 1;
        while (index != 0){
            String sub = sample.substring(index, index+1);
            decoded = decoded + sub;
            index = sample.indexOf("5", index) + 1;
        }
        return decoded;
    }

    public void newDefense(){
        for (int j = 0; j < 50; j++){
            for (int x = 0; x < shelters.length; x++) {
                for (int i = 0; i < shelters.length; i++) {
                    if (shelters[x].getDefenseLevel() == shelters[i].getDefenseLevel() && (x != i)) {
                        int newDefenseLevel = (int) (Math.random() * 100 + 1);
                        shelters[i].setDefenseLevel(newDefenseLevel);
                    }
                }
            }
        }
    }

    public boolean checkDefense(){
        boolean check = false;
        for(int x = 0; x < shelters.length; x++){
            for(int i = 0; i < shelters.length; i++){
                if(shelters[x].getDefenseLevel() == shelters[i].getDefenseLevel() && (x != i)){
                    check = true;
                    System.out.println("this:" + x + "this" + i);
                }
            }
        }
        return check;
    }
}