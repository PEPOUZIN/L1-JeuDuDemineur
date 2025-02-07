/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author pp541251
 */
public class Plateau {                                                          //Cette classe permettra la création du Plateau de jeu

    private Case[][] plateau;                                                   //Le Plateau est un tableau 2 dimensions contenant des Cases. 
    private int nblig;                                                          //Cet attribut est le nombre de lignes de ce tableau
    private int nbcol;                                                          //L'attribut est le nombre de colonnes de ce tableau
    private int bombe;                                                          //Ceci sera le nombre de bombes dans le tableau
    private int dificult;                                                       //Cet attribut sera la difficulté choisi dans le tableau, qui fera influencer le nombre de bombes dans le Plateau
    private boolean VoD;                                                        //Victoire ou defaite
    private int NbCaseVue;                                                      //Ceci est le nombre de Case découverte    
    private int NbDrapeauR;                                                     //Cet attribut est le nombre de Drapeau            

    public boolean isVoD() {
        return VoD;
    }

    public void setVoD(boolean VoD) {
        this.VoD = VoD;
    }

    public int getDificult() {
        return dificult;
    }

    public void setDificult(int dificult) {
        this.dificult = dificult;
    }

                                                                                //Constructeur avec paramètres de cette classe, il prend en compte le nombre de lignes, de colonnes et la difficulté choisi
    public Plateau(int lig, int col, int dif) {
        plateau = new Case[lig][col];                                           //On choisi la dimension du tableau avec le nombre de lignes et de colonnes         
        this.dificult = dif;                                                    //On affecte à l'attribut de la difficulté, dif
        this.nbcol = col;                                                       //On affecte à l'attribut colonne, col    
        this.nblig = lig;                                                       //De même pour l'attribut ligne avec lig        
        this.bombe = this.nblig * this.nbcol * this.dificult / 10;              //Le nombre de Bombes dans le plateau dépendera du nombre de lignes, de colonnes et la difficulté
        this.VoD = false;                                                       //On n'a pas encore gagné (ce serait trop simple sinon)
        this.NbCaseVue = 0;                                                     //Rien n'a encore été découvert
        this.NbDrapeauR = this.bombe;                                           //Et le nombre de Drapeau disponible, est égale au nombre de Bombes
    }

    public int getNbDrapeauR() {
        return NbDrapeauR;
    }

    //getter setter
    public Case getCasePlateau(int lig, int col) {
        return plateau[lig][col];
    }

    public int getNblig() {
        return nblig;
    }

    public void setNblig(int nblig) {
        this.nblig = nblig;
    }

    public int getNbcol() {
        return nbcol;
    }

    public void setNbcol(int nbcol) {
        this.nbcol = nbcol;
    }

                                                                                //On va initialiser le plateau avec des cases.
    public void initPlateu() {                                              
        int compteurM = 0;                                                      //On affecte un compteur de Mines à zéro afin de ne pas en mettre plus que prévu
        int ligne;
        int colone;
        while (compteurM != this.bombe) {                                       //Si le compteur de Mines n'est pas égale au nombre de Mines, cela signifie qu'on peut encore en rajouter 
            ligne = (int) (Math.random() * this.nblig);                         //On choisi une ligne et une colonne au hasard parmis celles disponibles
            colone = (int) (Math.random() * this.nbcol);
            if (this.plateau[ligne][colone] == null) {                          //Si rien n'a encore été mis dans cette case, alors on appel le constructeur de Mine afin de l'affecté à lcette position
                this.plateau[ligne][colone] = new Mine(ligne, colone, this);
                compteurM++;                                                    //On rajoute +1 au compteur afin d'avoir le nombre de Mines maximum selon le calcul de this.mines (cf: voir constructeur)    
            }
        }                                                                       //Comble les cases restantes avec des cases vides
        for (ligne = 0; ligne < this.nblig; ligne++) {                          //On parcourt ensuite le tableau de A à Z afin de vérifier là où il n' y a aucune Mine
            for (colone = 0; colone < this.nbcol; colone++) {
                if (this.plateau[ligne][colone] == null) {
                    this.plateau[ligne][colone] = new CaseVide(ligne, colone, this);//Dans ce cas, on appel le constructeur de Case Vide afin de l'insérer dans le tableau à cette position
                }
            }
        }

    }

    public int isBombe(int x, int y) {                                          //Cette méthode retourne 1 si la case est dans le tableau et que le nom de sa classe est "Mine", sinon retourne 0                                             
        if (x >= 0 && x < this.nblig && y >= 0 && y < this.nbcol && this.plateau[x][y].getClass().getSimpleName().equals("Mine")) {
            return 1;
        } else {
            return 0;
        }

    }

    public boolean enDehors(int x, int y) {                                     //Permet de retourner un booléan pour savoir si les cases sont à l'extérieur du tableau ou non
        if (x >= 0 && x < this.nblig && y >= 0 && y < this.nbcol) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {                                                  //Permet de retourner une chaîne de caractères afin de réstituer le tableau de Case
        String res = "";
        for (int i = 0; i < this.nblig; i++) {
            for (int j = 0; j < this.nbcol; j++) {
                res += plateau[i][j].toString() + " ";/*+this.plateau[i][j].getClass().getSimpleName()+ "";*/   //La partie en commentaire permeterra de savoir si ce sont des Mine ou non
            }
            res += "\n \n";
        }
        return res;
    }

    public void Decouvrir(int x, int y) {                                       //Méthode principale permettant de savoir sur quelle Case on tombe

        if (this.plateau[x][y].getClass().getSimpleName().equals("Mine")) {
            for (int i = 0; i < this.nblig; i++)                                //Permet d'afficher le nombre de bombe sur les cases a proximite des bombes et de dévoiler les cases
            {
                for (int j = 0; j < this.nbcol; j++) {
                    this.DevoileCaseAlentour(i, j);
                }
            }

            Perdu();                                                            //Appel la méthode Signifiant qu'on a Perdu

        } else {
            Verif();                                                            //Voir si on a gagné

            {

                DevoileCaseAlentour(x, y);                                      //On vérifie alors les cases aux alentours de celle-ci
                Verif();                                                        //Et reverifier si on a gagné
            }
        }
    }

    public void Verif() {                                                       //On vérifie que le nombre de lignes * le nombre de colonnes - les nombre de Mines soit égale au nombre de Cases découvertes
        int compteur = 0;
        for (int i = 0; i < this.nblig; i++) {                                  //On parcourt donc le tableau en entier        
            for (int j = 0; j < this.nbcol; j++) {
                if (this.plateau[i][j].isVisible()) {                           //Et on compte le nombre de cases que l'on a découvert
                    compteur++;
                }
            }
        }
        if (this.nbcol * this.nblig - this.bombe == compteur) {                 //Alors comme dit plus haut, si cela est respecté, alors on appel la méthode Gagner()
            Gagner();
        }
    }

    public boolean Gagner() {                                                   //Afiiche un message de victoire dans le terminal
        System.out.print("Vous avez Gagner" + "\n");
        return this.VoD = true;                                                 //Affecte l'attribut de Victoire/Défaite à true signifiant qu'on a fini
    }

    public boolean Perdu() {                                                    //Affiche un message de défaite dans le termal    
        System.out.print("Vous avez Perdu" + "\n"); 
        return this.VoD = true;                                                 //Affecte l'attribut de Victoire/Défaite à true signifiant qu'on a fini    
    }

    /*
* FONCTION CALCULER LE NB DE MINES AUTOUR
* fonction équivalente à NbMinesAutour() mais qui prend les paramètres de position de case
* retourne le nombre de mine qui se trouve autour d'une position
     */
    public int NbMinesAutourBis(int lignes, int colonnes) {
        int NbMA = 0;

        NbMA += isBombe(lignes + 1, colonnes);
        NbMA += isBombe(lignes + 1, colonnes + 1);
        NbMA += isBombe(lignes, colonnes + 1);
        NbMA += isBombe(lignes - 1, colonnes);
        NbMA += isBombe(lignes - 1, colonnes - 1);
        NbMA += isBombe(lignes, colonnes - 1);
        NbMA += isBombe(lignes + 1, colonnes - 1);
        NbMA += isBombe(lignes - 1, colonnes + 1);

        return NbMA;
    }
                                                                                //On effectue certaines vérifications avant de tout enlever
    public void DevoileCaseAlentour(int x, int y) {                             //Si la Case est en Dehors du terrain alors on ne retourne rien
        if (enDehors(x, y)) {
            return;
        }
        if (plateau[x][y].isVisible()) {                                        //Si kla case a déjà été joué alors on ne retourne rien
            return;
        }
        this.plateau[x][y].setVisible(true);                                    //A ce stade, on considère cette case comme "joué"
        if (this.plateau[x][y].isFlag()) {                                      //Si cette case est un drapeau, alors on ne retourne rien de même
            return;
        }
        if (this.NbMinesAutourBis(x, y) != 0) {                                 //Si le nombre de Mines autour est différent de 0, ce qui signifie qu'il y en a au moins une
            plateau[x][y].setNombreBprox(this.NbMinesAutourBis(x, y));          //Alors on affecte à la case, le nombre de Mines qu'il y a aux alentours
            return;                                                     
        }

        DevoileCaseAlentour(x - 1, y - 1);                                      //Sinon on appel la récursivité de chaque case aux alentours afin de refaire les mêmes tests sur elles
        DevoileCaseAlentour(x - 1, y + 1);                                      //Représentation de cette méthode:
        DevoileCaseAlentour(x + 1, y - 1);                                      //          [x-1:y-1]  [x:y-1]         [x+1:y-1]
        DevoileCaseAlentour(x + 1, y + 1);                                      //          [x-1:y]    [Case actuelle] [x+1:y]    
        DevoileCaseAlentour(x - 1, y);                                          //          [x-1:y+1]  [x:y+1]         [x+1:y+1]
        DevoileCaseAlentour(x + 1, y);                                          //        
        DevoileCaseAlentour(x, y - 1);
        DevoileCaseAlentour(x, y + 1);

    }

}
