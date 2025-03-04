public class MainThe {
    public static void main(String[] args) {
        CommandeThe theSimple = new CommandeThe.ConstructeurCommandeThe("Thé vert").construire();
        theSimple.afficherCommande();

        CommandeThe theLaitMiel = new CommandeThe.ConstructeurCommandeThe("Thé noir")
                .definirLait("Lait d'amande")
                .definirSucre(2)
                .ajouterMiel(true)
                .construire();
        theLaitMiel.afficherCommande();

        CommandeThe theCitronSucre = new CommandeThe.ConstructeurCommandeThe("Rooibos")
                .definirSucre(1)
                .ajouterCitron(true)
                .construire();
        theCitronSucre.afficherCommande();

        try {
            CommandeThe theInvalide = new CommandeThe.ConstructeurCommandeThe("Thé blanc")
                    .ajouterMiel(true)
                    .ajouterCitron(true)
                    .construire();
            theInvalide.afficherCommande();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
