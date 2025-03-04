public class Main {
    public static void main(String[] args) {
        CommandeCafe cafeNoir = new CommandeCafe.ConstructeurCommande("Café noir").construire();
        cafeNoir.afficherCommande();

        CommandeCafe cafeLaitSucre = new CommandeCafe.ConstructeurCommande("Cappuccino")
                .definirLait("Lait entier")
                .definirSucre(2)
                .construire();
        cafeLaitSucre.afficherCommande();

        CommandeCafe cafeGourmand = new CommandeCafe.ConstructeurCommande("Latte")
                .definirLait("Lait d'amande")
                .definirSucre(1)
                .ajouterOptions("Chantilly, sirop caramel")
                .construire();
        cafeGourmand.afficherCommande();
    }
}
