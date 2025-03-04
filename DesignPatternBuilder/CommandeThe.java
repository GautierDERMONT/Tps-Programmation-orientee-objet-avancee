public class CommandeThe {
    private String typeThe;
    private String typeLait;
    private int quantiteSucre;
    private boolean ajoutMiel;
    private boolean ajoutCitron;

    private CommandeThe(ConstructeurCommandeThe builder) {
        this.typeThe = builder.typeThe;
        this.typeLait = builder.typeLait;
        this.quantiteSucre = builder.quantiteSucre;
        this.ajoutMiel = builder.ajoutMiel;
        this.ajoutCitron = builder.ajoutCitron;
    }

    public void afficherCommande() {
        System.out.println("Commande de thé :");
        System.out.println("Type de thé : " + typeThe);
        System.out.println("Type de lait : " + (typeLait != null && !typeLait.equals("Aucun") ? typeLait : "Aucun"));
        System.out.println("Quantité de sucre : " + quantiteSucre);
        System.out.println("Ajout de miel : " + (ajoutMiel ? "Oui" : "Non"));
        System.out.println("Ajout de citron : " + (ajoutCitron ? "Oui" : "Non"));
        System.out.println("------------------------------------");
    }

    public static class ConstructeurCommandeThe {
        private String typeThe;
        private String typeLait = "Aucun";
        private int quantiteSucre = 0;
        private boolean ajoutMiel = false;
        private boolean ajoutCitron = false;

        public ConstructeurCommandeThe(String typeThe) {
            if (typeThe == null || typeThe.isEmpty()) {
                throw new IllegalArgumentException("Le type de thé est obligatoire.");
            }
            this.typeThe = typeThe;
        }

        public ConstructeurCommandeThe definirLait(String typeLait) {
            this.typeLait = typeLait;
            return this;
        }

        public ConstructeurCommandeThe definirSucre(int quantiteSucre) {
            if (quantiteSucre < 0) {
                throw new IllegalArgumentException("La quantité de sucre ne peut pas être négative.");
            }
            this.quantiteSucre = quantiteSucre;
            return this;
        }

        public ConstructeurCommandeThe ajouterMiel(boolean ajoutMiel) {
            this.ajoutMiel = ajoutMiel;
            return this;
        }

        public ConstructeurCommandeThe ajouterCitron(boolean ajoutCitron) {
            this.ajoutCitron = ajoutCitron;
            return this;
        }

        public CommandeThe construire() {
            if (ajoutMiel && ajoutCitron) {
                throw new IllegalArgumentException("Impossible d'ajouter du miel et du citron en même temps.");
            }
            return new CommandeThe(this);
        }
    }
}