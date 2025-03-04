public class TestsCommandeCafe {
    public static void main(String[] args) {
        try {
            CommandeCafe cafeSimple = new CommandeCafe.ConstructeurCommande("Espresso").construire();
            cafeSimple.afficherCommande();

            CommandeCafe cafeComplet = new CommandeCafe.ConstructeurCommande("Latte")
                    .definirLait("Lait entier")
                    .definirSucre(3)
                    .ajouterOptions("Chantilly, sirop caramel, vanille")
                    .construire();
            cafeComplet.afficherCommande();

            CommandeCafe cafePersonnalise = new CommandeCafe.ConstructeurCommande("Moka")
                    .definirLait("Lait d'avoine")
                    .definirSucre(1)
                    .construire();
            cafePersonnalise.afficherCommande();

            CommandeCafe cafeInvalide = new CommandeCafe.ConstructeurCommande("Café noir")
                    .ajouterOptions("Chantilly")
                    .construire();
            cafeInvalide.afficherCommande();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            CommandeCafe cafeSucreNegatif = new CommandeCafe.ConstructeurCommande("Macchiato")
                    .definirSucre(-1)
                    .construire();
            cafeSucreNegatif.afficherCommande();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
