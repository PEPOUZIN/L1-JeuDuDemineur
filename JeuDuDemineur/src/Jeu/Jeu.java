/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

//Ceci importe la classe Scanner du package java.util
import java.util.Scanner;
//Ceci importe toutes les classes du package java.util
import java.util.*;
import java.util.regex.*;

/**
 * ?
 *
 * @author pp541251
 */
public class Jeu {                                                              //Cette classe permettra de pouvoir lancer une partie

    public Jeu() {                                                              //On appel une méthode qui fera un affichage au lancement de la classe Jeu
        Start();
    }

    public void Start() {                                                                                   //Cette méthode est à but décoratif
        System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");                               
        System.out.println("💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣");
        System.out.println("=========================Jeu du Démineur=============================");
        System.out.println("💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣");
        System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");
        Scanner scan = new Scanner(System.in);                                                              //On ouvre un scanner 
        System.out.println("Voulez-vous jouez ?");                                                          //Et on demande au joueur de saisir une entrée
        String n = scan.nextLine();                                                                         //On lit la prochaine ligne

        if (n.matches("Oui")) {                                                                             //On vérifie avec un Regex que le joueur a marqué Oui

            System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");

            System.out.println("Choisisser une difficulté (1 à 9)");                                        //On demande après à l'utilisateur la difficulté qu'il voudra dans son jeu
            String str = "";
            do {                                                                                            //Si l'utilisateur ne met pas une difficulté entre 1 et 9
                Scanner sc = new Scanner(System.in);                                                        //Alors on lui redemendera
                str = sc.nextLine();                                                                        
            } while (!str.matches("[1-9]"));                                                                //Vérification que se soit bien un chiffre
            int difficult = Integer.parseInt(str);

            System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");

            System.out.println("Choisisser un nombre de ligne");                                            //On demande ensuite à l'utilisateur le nombre de lignes dans le Plateau    
            String stra = "";                                                                               //Biensûr s'il ne met que des lettres, cela ne fonctionnera pas
            do {                                                                                            //Et donc, on l'empêche de mettre des lettres grâce au REGEX        
                Scanner sca = new Scanner(System.in);
                stra = sca.nextLine();
            } while (!stra.matches("[0-9]*"));                                                              //[0-9] vérifie que ce que l'utilisateur marque se situe entre 0 et 9
            int ligne = Integer.parseInt(stra);                                                             //Et * signifie qu'il peut marquer un chiffre 1 fois ou plus, soit l'intervalle => {1,}
                                                                                                            //Au lieu d'utiliser NextInt(), on décide de montrer nos compétences en transformant le String en entier
            System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");

            System.out.println("Choisisser un nombre de colonne");                                          //Le nombre de colonnes du Plateau est ensuite demandé au joueur
            String strab = "";                                                                              //On réitére la même méthode que précédamment
            do {
                Scanner scab = new Scanner(System.in);
                strab = scab.nextLine();
            } while (!stra.matches("[0-9]*"));
            int colonne = Integer.parseInt(strab);

            System.out.println("🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩🚩");

            System.out.println("\n");
            Plateau j = new Plateau(ligne, colonne, difficult);                                             //On construit le plateau avec les paramètres de l'utilisateurs
            j.initPlateu();                                                                                 //On appel la méthode de la classe Plateau permettant de le créer avec les Mines et les Cases Vides
            System.out.println(j.toString());                                                               //Ensuite la méthode toString() sera appelé afin d'afficher dans le terminal le Plateau

            int compteurDrap = 0;                                                                           //Compte les drapeaux que l'on pose
            compteurDrap = j.getNbDrapeauR();                                                               

            while (!j.isVoD()) {                                                                            //Tant que la condition de victoire n'est pas respecté
                System.out.println("Choisissez une option");                                                //Alors on continu d'afficher ce menu
                System.out.println("1-Choisir une case à découvrir");
                System.out.println("2-Posez un drapeau");
                System.out.println("3-Drapeau à enlever");
                System.out.println("4-Quitter le jeu");

                String stchoix = "";
                do {
                    Scanner schoix = new Scanner(System.in);                                                //On ouvre un sacnner afin de vérifier que le joueur rentre bien un nombre entre 1 et 4
                    stchoix = schoix.nextLine();
                } while (!stchoix.matches("[1234]"));//Verification
                int choix = Integer.parseInt(stchoix);

                switch (choix) {                                                                            //On vérifie grâce à un switch le choix de l'utilisateur
                    case 1:                                                                                 //S'il a voulu découvrir un =e case, alors:
                        System.out.println("Choisir une case à découvrir");
                        String sx = "";
                        int x;                                                                              //On lui demande de saisir x    
                        do {
                            sx = ChoisirCaseX();
                            x = Integer.parseInt(sx);
                        } while (x > ligne - 1);                                                            //en vérifiant que celui-ci ne soit pas dehors
                        String sy = "";
                        int y;                                                                              //On fait de même pour y
                        do {
                            sy = ChoisirCaseY();
                            y = Integer.parseInt(sy);
                        } while (y > colonne - 1);
                        if (j.getCasePlateau(x, y).isVisible()) {                                           //On vérifie que la Case joué ne soit pas encore découverte    

                            System.out.println("Case déjà découverte");                                     //Si c'est le cas, alors on affiche un messsage d'erreur
                            break;
                        } else {

                            j.Decouvrir(x, y);                                                              //Sinon on appel une méthode qui permettra de découvrir la Case
                            System.out.println(j.toString());
                            break;
                        }

                    case 2:                                                                                 //Si on a choisit de poser un drapeau
                        if (compteurDrap > 0) {                                                             //Et que le nombre de Drapeaux posés n'est pas supérieurs aux nombres de Mines sur le Terrain
                            System.out.println("Choisir une drapeau a poser");                              //Alors on demande à l'utlisateur les coordonnée de celui-ci
                            String ssx = ChoisirCaseX();
                            int xx = Integer.parseInt(ssx);
                            String ssy = ChoisirCaseY();
                            int yy = Integer.parseInt(ssy);
                            j.getCasePlateau(xx, yy).setFlag(true);
                            System.out.println(j.toString());
                            compteurDrap = j.getNbDrapeauR() - 1;                                           //Toute en ittérant au compteur un drapeau disponible
                        } else {
                            System.out.println("Vous n'avez plus de drapeau \n");                           //Dans le cas où la condition du dessus n'est pas respecté, càd que le nombre de drapeaux est égale au nombre de Mines alors On ne peut plus en poser    
                        }
                        break;
                    case 3:
                        if (compteurDrap >= j.getNbDrapeauR()) {                                            //Si l'utilisateur veut enlever un drapeau
                            System.out.println("Vous n'avez pas de drapeau sur le terrain \n");             //On vérifie qu'il y en déjà un sur le Plateau et dans le cas contraire on affiche un message d'erreur
                        } else {
                            System.out.println("Choisir une drapeau a enlever");                            //Sinon on demande les coordonnées de celui-ci
                            String sssx = ChoisirCaseX();
                            int xxx = Integer.parseInt(sssx);
                            String sssy = ChoisirCaseY();
                            int yyy = Integer.parseInt(sssy);
                            j.getCasePlateau(xxx, yyy).setFlag(false);                                      //Grâce à l'accesseur en écriture, on peut enlever le Drapeau sur cette case
                            System.out.println(j.toString());                                               //Sans oublier d'appeler la méthode toString() afin de réafficher la case
                            compteurDrap = j.getNbDrapeauR() + 1;                                           //Le nombre de Drapeau gagne 1 afin de pouvoir en reposer
                        }

                        break;
                    case 4:                                                                                 //Dans le cas où l'utilisateur veut quitter la partie alors System.exit(0) le fera
                        System.exit(0);
                        break;
                }

            }
            System.out.println("💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣");
            System.out.println("=====================Voulez vous rejouer ?===========================");            //A la fin, nous demandons tout de même si le joueur veut rejouer
            System.out.println("💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣💣");
            Scanner sc = new Scanner(System.in);
            String s = "";
            s = sc.nextLine();
            if (s.equals("Oui")) {                                              //Si c'est le cas, alors on réappelle la méthode Start() afin de réafficher le menu du début
                Start();
            } else {
                System.exit(0);                                                 //Sinon on met fin au programme
            }

        }

    }

    public String ChoisirCaseX() {                                                                              //Notre méthode ChoisirCaseX() permet un affichage correct 
        Scanner sc = new Scanner(System.in);                                                                    //Il vérifie avec les REGEX que ce soit un nombre
        System.out.println("====================Veuillez saisir une coordonnée en X:====================");
        String str = "";
        do {
            str = sc.nextLine();
        } while (!str.matches("[0-9]+"));
        return str;
    }

    public String ChoisirCaseY() {                                                                              //La même chose est ainsi faite pour cette méthode
        Scanner sc = new Scanner(System.in);
        System.out.println("====================Veuillez saisir une coordonnée en Y:====================");
        String str = "";
        do {
            str = sc.nextLine();
        } while (!str.matches("[0-9]+"));
        return str;
    }

}
