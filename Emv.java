import java.time.LocalDateTime;

public class Emv {

	public static void main(String[] args) {
		banner();
		entorno();
		latido();
	}

	private static void banner() {
		System.out.println("╔══════════════════════════════╗");
		System.out.println("║   EMV Java · Vivo y mínimo   ║");
		System.out.println("╚══════════════════════════════╝");
	}

	private static void entorno() {
		System.out.println("\n[Entorno]");
		System.out.println("Java    : " + System.getProperty("java.version"));
		System.out.println("OS      : " + System.getProperty("os.name"));
		System.out.println("Fecha   : " + LocalDateTime.now());

		String hostname = System.getenv("HOSTNAME");
		System.out.println("Docker  : " + (hostname != null ? "sí (" + hostname + ")" : "no detectado"));
	}

	private static void latido() {
		long memoria = Runtime.getRuntime().maxMemory() / (1024 * 1024);

		System.out.println("\n[Latido]");
		System.out.println("Memoria : " + memoria + " MB");
		System.out.println("Estado  : estable ✔");

		System.out.println("\nEMV listo. Sin dependencias. Sin ruido.");
	}
}
