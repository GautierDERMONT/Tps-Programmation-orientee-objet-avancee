public class CommandeCafe {
    private String typeCafe;
    private String typeLait;
    private int quantiteSucre;
    private String optionsSupplementaires;

    private CommandeCafe(ConstructeurCommande builder) {
        this.typeCafe = builder.typeCafe;
        this.typeLait = builder.typeLait;
        this.quantiteSucre = builder.quantiteSucre;
        this.optionsSupplementaires = builder.optionsSupplementaires;
    }

    public void afficherCommande() {
        System.out.println("Commande de café :");
        System.out.println("Type de café : " + typeCafe);
        System.out.println("Type de lait : " + (typeLait != null ? typeLait : "Aucun"));
        System.out.println("Quantité de sucre : " + quantiteSucre);
        System.out.println("Options supplémentaires : " + (optionsSupplementaires != null ? optionsSupplementaires : "Aucune"));
    }

    public static class ConstructeurCommande {
        private String typeCafe;
        private String typeLait = "Aucun";
        private int quantiteSucre = 0;
        private String optionsSupplementaires = "Aucune";

        public ConstructeurCommande(String typeCafe) {
            this.typeCafe = typeCafe;
        }

        public ConstructeurCommande definirLait(String typeLait) {
            this.typeLait = typeLait;
            return this;
        }

        public ConstructeurCommande definirSucre(int quantiteSucre) {
            this.quantiteSucre = quantiteSucre;
            return this;
        }

        public ConstructeurCommande ajouterOptions(String optionsSupplementaires) {
            this.optionsSupplementaires = optionsSupplementaires;
            return this;
        }

        public CommandeCafe construire() {
            return new CommandeCafe(this);
        }
    }

    public static void main(String[] args) {
        CommandeCafe commande = new CommandeCafe.ConstructeurCommande("Espresso")
                .definirLait("Lait d'amande")
                .definirSucre(2)
                .ajouterOptions("Chantilly, sirop caramel")
                .construire();
        
        commande.afficherCommande();
    }
}
