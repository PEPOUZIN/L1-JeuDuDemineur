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





public abstract class Case {                                                    //Cete classe abstract est utile car nous utilisons 2 types de cases, les Mines et les Cases Vides                
    private int x;                                                              //Cet attribut sert de coordonnée X à la Case
    private int y;                                                              //Cet attribut sert de coordonnée Y à la Case
    private boolean visible;                                                    //Cet attribut sert à savoir si une Case peut être joué ou non
    private Plateau p;                                                          //Chaque case pourra accéder au Plateau qui l'a créé grâce à cette attribut
    private int NombreBprox;                                                    //Cet attribut nous servira à retourner le nombre de Mines aux alentours de la Case dévoilée
    private boolean flag;                                                       //Celui-ci aura pour but de savoir si n drapeau a déjà été placé sur une Case 
             
    
    
    
                           //ACCESSEURS ET SETTEURS DE LA CLASSE\\
    
    
    
    
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getNombreBprox() {
        return NombreBprox;
    }

    public void setNombreBprox(int NombreBprox) {
        this.NombreBprox = NombreBprox;
    }
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Plateau getP() {
        return p;
    }

    public void setP(Plateau p) {
        this.p = p;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Case(int x, int y, Plateau p) {                                      //Constructeur standard de cette classe
        this.x = x;                                                             
        this.y = y;
        this.visible = false;
        this.p = p;
        this.flag=false;
    }

    public abstract String toString();                                          //Méthode toString en abstract afin d'avoir différents affichages si c'est une Mine ou une Case Vide
    
    
}
