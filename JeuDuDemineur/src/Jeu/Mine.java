/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author pp541251
 */
public class Mine extends Case {                                                //Cette classe est donc dérivée de Case et permettra donc de créer des Mines dans le Plateau

    public Mine(int x, int y, Plateau p) {                                      //Constructeur strandard qui fait appel au constructeur parent de la classe Case.
        super(x, y, p);                                                         //x étant le position x, y étant la position y et p, le plateau dans lequel seront les Case

    }

    public String toString() {                                                  //La méthode toString() appelé par la classe parent permet de retourner plusieurs informations
        if (this.isFlag()) {                                                    //Si la Case contient un drapeau:  
            return " |  🚩  | ";                                                 //           Alors on l'affiche   
        }
        if (isVisible()) {                                                      //Si la Case a été joué
            return " |  ⳝ  | ";                                                 //           Alors on affiche une Bombe pour signifier qu'on a perdu
        } else {
            return " | " + this.getX() + ":" + this.getY() + " | ";             //Sinon on retourne l'affichage de base, càd les coordonnées x:y
        }
    }

}
