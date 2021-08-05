import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);

        while (playAgain) {
            introduction(petShelter);
            int careChoice = input.nextInt();
            input.nextLine();
            playerChoice(petShelter, input, careChoice);
            tickAll(petShelter);
            while (winConditions(petShelter)) {
                scoreboard(petShelter);
                userChoices();
                careChoice = input.nextInt();
                playerChoice(petShelter, input, careChoice);
                tickAll(petShelter);
            }
            petShelter.resetShelterState();
            playAgain = isPlayAgain(input);
        }
    }

    private static void introduction(VirtualPetShelter petShelter) {
        System.out.println("Hello!");
        System.out.println("Welcome to the Virtual Pet Shelter!");
        System.out.println("I know it's your first day here but I'm sure you will do great!\n");
        petShelter.addInitialPetsToShelter();
        System.out.println("Here are the pets that currently live at the shelter:");
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            System.out.println(shelterPet.getName() + ", " + shelterPet.getDescription());
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            System.out.println(shelterPet.getName() + ", " + shelterPet.getDescription());
        }
        System.out.println("\nHere are the current stats of your pets in the shelter:");
        scoreboard(petShelter);
        System.out.println("\nSince we have a lot of different kinds of pets in the shelter you can do lots of things with them." +
                "\nEach action will change stats based on which pet(s) chosen." +
                "\nThe only problem is that one action takes all day, so choose wisely." +
                "\nHere is the list of things you can do with the shelter!\n");
        userChoices();
    }

    private static void scoreboard(VirtualPetShelter petShelter) {
        System.out.println("|---------------------------------------------------- Current Shelter Stats ----------------------------------------------------|");
        System.out.println("|-----------------------|---------------|---------------|---------------|---------------|---------------|-----------------------|");
        System.out.println("|\t  Organic Pets\t\t|\t Hunger\t\t|\t Thirst\t\t|\t Boredom\t|\tTiredness\t|\t Bathroom\t|\tCrate Cleanliness\t|");
        System.out.println("|-----------------------|---------------|---------------|---------------|---------------|---------------|-----------------------|");

        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            System.out.println("|\t   " + shelterPet.getName() + "\t\t\t|\t\t" +
                    shelterPet.getHunger() + " \t\t|\t\t" +
                    shelterPet.getThirst() + " \t\t|\t\t" +
                    shelterPet.getBoredom() + " \t\t|\t\t" +
                    shelterPet.getTiredness() + " \t\t|\t\t" +
                    shelterPet.getBathroom() + " \t\t|\t\t\t" +
                    shelterPet.getCleanliness() + " \t\t\t|");
        }
        System.out.println("|-----------------------|---------------|---------------|---------------|---------------|---------------|-----------------------|");
        System.out.println("|\t  Robotic Pets\t\t|\t\t  Battery Level\t\t\t|\tCondition\t|\t    Crate Cleanliness\t\t|");
        System.out.println("|-----------------------|-------------------------------|---------------|-------------------------------|");

        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            System.out.println("|\t   " + shelterPet.getName() + "\t\t\t|\t\t\t\t" +
                    shelterPet.getBattLevel() + " \t\t\t\t|\t\t" +
                    shelterPet.getConditionLevel() + " \t\t|\t\t\t\t" +
                    shelterPet.getCleanliness() + " \t\t\t\t|");
        }
        System.out.println("|-----------------------|-------------------------------|---------------|-------------------------------|");
    }

    private static void userChoices() {
        System.out.println("Choose an option:");
        System.out.println("1. Play with a pet in the shelter.");
        System.out.println("2. Water a pet in the shelter.");
        System.out.println("3. Feed a pet in the shelter.");
        System.out.println("4. Let pets rest and recharge.");
        System.out.println("5. Walk the dog around the neighborhood.");
        System.out.println("6. Clean out the pets crates.");
        System.out.println("7. Repair robotic pets.");
        System.out.println("8. Admit a new pet to the shelter.");
        System.out.println("9. Adopt a pet out to a home.");
    }

    private static void playerChoice(VirtualPetShelter petShelter, Scanner input, int careChoice) {
        switch (careChoice) {
            case 1:
                playPet(petShelter, input);
                break;
            case 2:
                waterPet(petShelter, input);
                break;
            case 3:
                feedPet(petShelter, input);
                break;
            case 4:
                restPets(petShelter);
                break;
            case 5:
                dogWalk(petShelter);
                break;
            case 6:
                cleanPets(petShelter);
                break;
            case 7:
                repairBots(petShelter);
                break;
            case 8:
                admitPet(petShelter, input);
                break;
            case 9:
                adoptPet(petShelter, input);
                break;
        }
    }

    private static void playPet(VirtualPetShelter petShelter, Scanner input) {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet would you like to play with?");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }
            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }
            String playPet = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(playPet)) {
                    pet.play();
                    foundPet = true;
                    System.out.println("\nYou give some one-on-one time to " + playPet + ".");
                    petNotPlayedWith = false;
                    break;
                }
            }
            for (RoboticPet pet : petShelter.roboticPetStorage) {
                if (pet.getName().equalsIgnoreCase(playPet)) {
                    pet.play();
                    foundPet = true;
                    System.out.println("\nYou give some one-on-one time to " + playPet + ".");
                    petNotPlayedWith = false;
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that pet is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }
    }

    private static void waterPet(VirtualPetShelter petShelter, Scanner input) {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet would you like to give water to?");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }
            String waterPet = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(waterPet)) {
                    pet.drink();
                    foundPet = true;
                    System.out.println("\nYou waterboarded " + waterPet + ".");
                    petNotPlayedWith = false;
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that pet is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }

    }

    private static void feedPet(VirtualPetShelter petShelter, Scanner input) {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet would you like to give food to?");
        while (petNotPlayedWith) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }
            input.nextLine();
            String feedPet = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet pet : petShelter.organicPetStorage) {
                if (pet.getName().equalsIgnoreCase(feedPet)) {
                    pet.eat();
                    foundPet = true;
                    System.out.println("\nYou give some water to " + feedPet + ".");
                    petNotPlayedWith = false;
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that pet is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }

    }

    private static void restPets(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.sleep();
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.charge();
        }
        System.out.println("You allow the pets to rest up and energize.");
    }

    private static void dogWalk(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            if (shelterPet instanceof OrganicDog) {
                ((OrganicDog) shelterPet).walk();
            }
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            if (shelterPet instanceof RoboticDog) {
                ((RoboticDog) shelterPet).walk();
            }
        }
        System.out.println("You walk the dogs around the neighborhood!");
    }

    private static void cleanPets(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.cleanCages();
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.cleanCages();
        }
        System.out.println("You made sure to clean the pets! Now they look presentable!");
    }

    private static void repairBots(VirtualPetShelter petShelter) {
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.maintenance();
        }
        System.out.println("You've just oiled up your bot!! ");
    }

    private static void admitPet(VirtualPetShelter petShelter, Scanner input) {
        System.out.println("In order to admit an animal, please provide the following information as it is requested.");
        System.out.print("Animal Name: ");

        String admittedAnimalName = input.nextLine();

        System.out.print("Brief description: ");

        String admittedAnimalDescription = input.nextLine();

        System.out.print("Is your pet Robotic or Organic? ");

        String admittedAnimalType = input.nextLine();

        if (admittedAnimalType.equalsIgnoreCase("Robotic")) {
            System.out.print("Is your pet a Dog or a Cat? ");
            String admittedAnimalSpecies = input.nextLine();
            if (admittedAnimalSpecies.equalsIgnoreCase("Dog")) {
                RoboticDog newDog = new RoboticDog(admittedAnimalName, admittedAnimalDescription, 50, 50, 50);
                petShelter.roboticPetStorage.add(newDog);
            } else if (admittedAnimalSpecies.equalsIgnoreCase("Cat")) {
                RoboticCat newCat = new RoboticCat(admittedAnimalName, admittedAnimalDescription, 50, 50, 50);
                petShelter.roboticPetStorage.add(newCat);
            }
        }
        if (admittedAnimalType.equalsIgnoreCase("Organic")) {
            System.out.print("Is your pet a Dog or a Cat? ");
            String admittedAnimalSpecies = input.nextLine();
            if (admittedAnimalSpecies.equalsIgnoreCase("Dog")) {
                OrganicDog newDog = new OrganicDog(admittedAnimalName, admittedAnimalDescription, 50, 50, 50, 50, 50, 50);
                petShelter.organicPetStorage.add(newDog);
            } else if (admittedAnimalSpecies.equalsIgnoreCase("Cat")) {
                OrganicCat newCat = new OrganicCat(admittedAnimalName, admittedAnimalDescription, 50, 50, 50, 50, 50, 50);
                petShelter.organicPetStorage.add(newCat);
            }
        }
        System.out.println("Thank you for admitting " + admittedAnimalName);
    }

    private static void adoptPet(VirtualPetShelter petShelter, Scanner input) {
        System.out.println("Which animal are you looking to adopt?");
        while (true) {
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }
            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
                System.out.println(shelterPet.getName() + ",  " + shelterPet.getDescription());
            }

            String petToAdopt = input.nextLine();
            boolean foundPet = false;
            for (OrganicPet shelterPet : petShelter.organicPetStorage) {
                if (shelterPet.getName().equalsIgnoreCase(petToAdopt)) {
                    foundPet = true;
                    petShelter.organicPetStorage.removeIf(pet -> pet.getName().equalsIgnoreCase(petToAdopt));
                    System.out.println("Thank you for adopting " + petToAdopt + ".");
                    break;
                }
            }
            for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
                if (shelterPet.getName().equalsIgnoreCase(petToAdopt)) {
                    foundPet = true;
                    petShelter.roboticPetStorage.removeIf(pet -> pet.getName().equalsIgnoreCase(petToAdopt));
                    System.out.println("Thank you for adopting " + petToAdopt + ".");
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that animal is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }
    }

    private static void tickAll(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            shelterPet.tick();

        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            shelterPet.tick();
        }
    }

    private static boolean isPlayAgain(Scanner input) {
        System.out.println("Would you like to play again? Y/N");
        String yOrN = input.nextLine();
        if (yOrN.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean winConditions(VirtualPetShelter petShelter) {
        for (OrganicPet shelterPet : petShelter.organicPetStorage) {
            if (shelterPet.getHunger() >= 100 || shelterPet.getThirst() >= 100 || shelterPet.getTiredness() >= 100 || shelterPet.getBoredom() >= 100 || shelterPet.getCleanliness() <= 0 || shelterPet.getBathroom() >= 100) {
                System.out.println(shelterPet.getName() + " has died! You lose.");
                return false;
            }
        }
        for (RoboticPet shelterPet : petShelter.roboticPetStorage) {
            if (shelterPet.getConditionLevel() <= 0 || shelterPet.getBattLevel() <= 0 || shelterPet.getCleanliness() <= 0) {
                System.out.println(shelterPet.getName() + " has died! You lose.");
                return false;
            }
        }
        if (petShelter.organicPetStorage.size() <= 0 && petShelter.roboticPetStorage.size() <= 0) {
            System.out.println("All of the pets have been adopted! You win!!!");
            return false;
        }
        return true;
    }
}

