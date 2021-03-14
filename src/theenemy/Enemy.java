package theenemy;

public class Enemy {


    public static void main(String[] args) {

        int bossHP = 3;
        int playerHP = 3;
        while (bossHP != 0 || playerHP != 0) {
            //player choice goes here
            String playerChoice = "Attack";
            String monsterChoice = "Attack";
            String monsterNextChoice = "Something";

            //Attack
            if (playerChoice == "Attack" && monsterChoice == "Defend") {
                System.out.println("Your attack was blocked!");
            }
//            else if (playerChoice == "Attack" && monsterChoice == "Attack") {
//                bossHP--;
//                playerHP--;
//                System.out.println("You both take damage! -1 to both HP");
//            }

            //Defend
            else if (playerChoice == "Defend" && monsterChoice == "Defend") {
                System.out.println("You both did absolutely nothing.");
            }
            else if (playerChoice == "Defend" && monsterChoice == "Attack") {
                System.out.println("You successfully blocked the spider's attack!");
            }

            //Sweep
            else if (playerChoice == "Sweep" && monsterChoice == "Attack") {
                playerHP--;
                System.out.println("The spider hit you before you could sweep!");
            }
            else if (playerChoice == "Sweep" && monsterChoice == "Defend") {
                System.out.println("You stunned the spider for 1 turn!");
            }
//            else if (playerChoice == "Attack" && monsterChoice == "Stunned") {
//                System.out.println("You successfully damaged the spider!");
//            }
//            System.out.println("Your HP: " + playerHP + "\nSpider HP: " + bossHP);
        }
        if (bossHP == 0) {
            System.out.println("You successfully killed the spider!");
        }
        else if (playerHP == 0) {
            System.out.println("You died");
        }
        System.out.println("              (\n" +
                "               )\n" +
                "              (\n" +
                "        /\\  .-\"\"\"-.  /\\\n" +
                "       //\\\\/  ,,,  \\//\\\\\n" +
                "       |/\\| ,;;;;;, |/\\|\n" +
                "       //\\\\\\;-\"\"\"-;///\\\\\n" +
                "      //  \\/   .   \\/  \\\\\n" +
                "     (| ,-_| \\ | / |_-, |)\n" +
                "       //`__\\.-.-./__`\\\\\n" +
                "      // /.-(() ())-.\\ \\\\\n" +
                "     (\\ |)   '---'   (| /)\n" +
                "      ` (|           |) `\n" +
                "        \\)           (/");
    }
}
