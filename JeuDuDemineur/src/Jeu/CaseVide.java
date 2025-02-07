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
public class CaseVide extends Case {                                            //Cette classe est donc dérivée de Case et permettra donc de créer des Cases Vides dans le Plateau

    public CaseVide(int x, int y, Plateau p) {                                  //Constructeur strandard qui fait appel au constructeur parent de la classe Case.
        super(x, y, p);                                                         //x étant le position x, y étant la position y et p, le plateau dans lequel seront les Case

    }

    public String toString() {                                                  //La méthode toString() appelé par la classe parent permet de retourner plusieurs informations
        if (this.isFlag()) {                                                    //Si la Case contient un drapeau:    
            return " |  🚩  | ";                                                 //           Alors on l'affiche   
        }
        if (isVisible() && this.getNombreBprox() == 0) {                        //Si la Case a été joué et que le nombre de Mines autour est de 0:
            return " |     | ";                                                 //           Alors on affichera une Case vide car il n'y a rien
        } else if (getNombreBprox() > 0) {                                      //Si ce nombre de Mines est supérieur à 0 alors on affiche le nombre de Bombes dans cette Case
            return " |  " + getNombreBprox() + "  | ";
        } else {                                                                
            return " | " + this.getX() + ":" + this.getY() + " | ";             //Si rien de tout cela n'est respecté alors on retourne tout simplement la coordonnée de la Case
        }

    }

}
