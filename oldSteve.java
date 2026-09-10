class Picareta {
    private final String material;
    private int durabilidade;
    private final int forca;

    public Picareta(String material, int durabilidade, int forca) {
        if (durabilidade <= 0 || forca <= 0) {
            System.out.println("Durabilidade e força devem ser maiores que zero");
        }

        this.material = material;
        this.durabilidade = durabilidade;
        this.forca = forca;
        System.out.println("\n=== FABRICANDO PICARETA ===");
        System.out.println("Material: " + material);
        System.out.println("Durabilidade: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Picareta de " + material + " fabricada com sucesso!");
    }

    public void minerar(int blocos) {
        System.out.println("\n=== MINERANDO COM PICARETA DE " + material.toUpperCase() + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Blocos a minerar: " + blocos);

        if (durabilidade <= 0) {
            System.out.println("Picareta quebrada!");
            return;
        }

        int blocosMinerados = 0;
        for (int i = 0; i < blocos; i++) {
            if (durabilidade <= 0) {
                System.out.println(" Picareta quebrou no bloco " + (i + 1));
                break;
            }
            durabilidade--;
            blocosMinerados++;
        }

        System.out.println("\nMinerados " + blocosMinerados + " blocos");
        System.out.println("Durabilidade restante: " + durabilidade);

        if (durabilidade <= 0) {
            System.out.println(" A picareta de " + material + " quebrou completamente!");
        }
    }

    public void reparar(int quantidade) {
        System.out.println("\n=== REPARANDO PICARETA DE " + material.toUpperCase() + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Quantidade a reparar: " + quantidade);

        int durabilidadeNova = durabilidade + quantidade;
        int limiteMaximo;
        switch (material.toLowerCase()) {
            case "madeira": limiteMaximo = 50; break;
            case "pedra": limiteMaximo = 70; break;
            case "ferro": limiteMaximo = 100; break;
            case "ouro": limiteMaximo = 30; break;
            default: limiteMaximo = 60;
        }

        if (durabilidadeNova > limiteMaximo) {
            System.out.println(" Reparo limitado a " + limiteMaximo);
            durabilidadeNova = limiteMaximo;
        }

        durabilidade = durabilidadeNova;
        System.out.println(" Durabilidade nova: " + durabilidade);
    }

    @Override
    public String toString() {
        return "Picareta de " + material + " (D: " + durabilidade + ", F: " + forca + ")";
    }
}

public class oldSteve {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   VELHO STEVE - FÁBRICA DE PICARETAS MANUAL         ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        Picareta p1 = new Picareta("madeira", 50, 5);
        Picareta p2 = new Picareta("pedra", 70, 8);
        Picareta p3 = new Picareta("ferro", 100, 12);

        System.out.println("\nPicaretas fabricadas:");
        System.out.println("  • " + p1);
        System.out.println("  • " + p2);
        System.out.println("  • " + p3);

        System.out.println("\n  Usando picaretas para minerar...");
        p3.minerar(30);
        p3.minerar(20);

        System.out.println("\n Criando picareta de ouro...");
        Picareta p4 = new Picareta("ouro", 30, 15);

        System.out.println("\n Reparando a picareta de ferro...");
        p3.reparar(50);

        System.out.println("\nEstado final das picaretas:");
        System.out.println("  • " + p1);
        System.out.println("  • " + p2);
        System.out.println("  • " + p3);
        System.out.println("  • " + p4);
    }
}
