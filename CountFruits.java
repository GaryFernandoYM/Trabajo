import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountFruits {

    //Este es el método principal del programa. Es donde comienza y termina el programa. 
    public static void main(String[] args) {
        // Crear un arreglo de objetos de tipo Fruta

        //Esta es una declaración de variable. Declara una matriz de objetos de tipo Fruit.
        Fruit[] fruits = {
            //Este es un constructor que crea un objeto de tipo Fruit. Toma dos parámetros, el primero es el nombre de la fruta y el segundo es un valor booleano que indica si es dulce o amargo
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
                new Fruit("platano", true),
                new Fruit("melon", true),
                new Fruit("chirimoya", true),
                new Fruit("pera", true),
                new Fruit("piña", false),
                new Fruit("mandarina", false),
                new Fruit("naranja", false),
                new Fruit("lima", false),
                new Fruit("limon", false),
        };

        // contar frutas dulces y amargos
        //Esta es una sentencia que declara una variable de tipo long. Almacena la hora actual en nanosegundos.
        long tiempoInicio = System.nanoTime();
        //Esta es una llamada de método. Llama al método parallelCount y le pasa dos parámetros: una matriz de objetos Fruit y un valor booleano. El método devuelve un valor entero que representa la cantidad de frutas en la matriz que son dulces.
        int countSweet = parallelCount(fruits, true);
        //Esta es una llamada de método. Llama al método parallelCount con dos parámetros, fruit y false. El primer parámetro es una matriz de objetos Fruit, y el segundo parámetro es un valor booleano que indica si queremos contar frutas dulces o amargas.
        int countBitter = parallelCount(fruits, false);
        //Este es un método que devuelve la hora actual en nanosegundos. Se utiliza para medir el tiempo de ejecución de un programa.
        long tiempoFin = System.nanoTime();

        // Imprimir resultados
        System.out.println("Número de frutas dulces: " + countSweet);
        System.out.println("Número de frutas amargas: " + countBitter);
        // System.out.println("Número de frutas dulces: " + countBitter);
        System.out.println("Tiempo de ejecución con programación paralela: " + (tiempoFin - tiempoInicio));

        // Contar frutas dulces y amargas programación paralela
        tiempoInicio = System.nanoTime();
        int countSweetSequential = sequentialCount(fruits, true);
        int countBitterSequential = sequentialCount(fruits, false);
        //Esta es una declaración de variable. Declara una variable llamada tiempoIniciode tipo long. El valor que se le asigna es el resultado de llamar al método System.nanoTime(). Este método devuelve la hora actual en nanosegundos, que es una medida de tiempo muy precisa.
        tiempoFin = System.nanoTime();

        // Imprimir resultados
        System.out.println("Número de frutas dulces y amargas programación paralela: " + countSweetSequential);
        System.out.println("Número de frutas dulces y amargas programación paralela: " + countBitterSequential);
        System.out.println("Tiempo de ejecución sin programación paralela: " + (tiempoFin - tiempoInicio));
    }
    //Este es un método que cuenta la cantidad de frutas en una matriz que son dulces o amargas. Toma dos parámetros, una matriz de objetos de tipo Fruit y un valor booleano. El valor booleano indica si la fruta es dulce o amarga. Si es verdad, significa que la fruta es dulce, de lo contrario es amarga.
    public static int sequentialCount(Fruit[] fruits, boolean sweet) {
        //Esta es una declaración de variable. Declara una variable entera nombrada numbery la inicializa a 0.
        int count = 0;
        //Este es un bucle for. Iterará a través de la matriz de frutas y ejecutará el código dentro de las llaves.
        for (Fruit fruit : fruits) {
            //Esta es una declaración condicional. Comprueba si el valor booleano del parámetro sweet en la clase fruit es igual al valor booleano de la dulcevariable en esta clase. Si lo hace, devolverá verdadero y ejecutará cualquier código que esté dentro de su bloque. De lo contrario, devolverá falso y omitirá ese código.
            if (fruit.sweet() == sweet) {
                //Esta es una declaración que incrementa el valor de la variable cuenta en 1.
                count++;
            }
        }
        //Esta es una declaración de devolución. Devuelve el valor de count al método que lo llamó que esta en la linea 101.
        return count;
    }
    //Este es un método que cuenta el número de frutas en una matriz. Toma dos parámetros, uno es una matriz de objetos de tipo Fruit y el otro es un valor booleano. El valor booleano indica si la fruta es dulce o no. Si es cierto, solo contará las frutas dulces, de lo contrario, solo contará las frutas amargas.
    public static int parallelCount(Fruit[] fruits, boolean sweet) {
        //Esta es una declaración que declara una variable llamada numThreads. Asigna el valor del número de procesadores disponibles al programa.
        int numThreads = Runtime.getRuntime().availableProcessors();
        //Esta es una declaración de una variable. Declara un objeto de tipo ExecutorService. Este objeto se usará para crear hilos que contarán la cantidad de frutas en la matriz. El parámetro pasado al método newFixedThreadPool es un número entero que indica cuántos subprocesos se van a crear. en este caso son 4
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        //Esta es una declaración de variable. Declara una variable llamada chunkSize de tipo int. El valor asignado a esta variable es el techo de la división entre el largo de frutos y numThreads.
        int chunkSize = (int) Math.ceil((double) fruits.length / numThreads);
        //Esta es una declaración de una matriz de enteros. Se utilizará para almacenar los resultados.
        int[] results = new int[numThreads];
        //Este es un método que crea una secuencia de números enteros de 0 a numThreads. Se utiliza para crear los hilos en el programa.
        IntStream.range(0, numThreads)
                //Este es un método que toma una matriz de objetos y la divide en partes. Luego crea un nuevo hilo para cada trozo y cuenta la cantidad de frutas dulces en cada trozo. Los subprocesos se ejecutan simultáneamente, por lo que se pueden procesar al mismo tiempo. Esto hace que el programa sea más rápido que si contara todas las frutas secuencialmente.
                .mapToObj(i -> new CountTask(fruits, i * chunkSize, Math.min((i + 1) * chunkSize, fruits.length),
                        //Esta es una llamada de método. Llama al método countFruity le pasa tres parámetros: results, i y sweet. El método devuelve un valor entero, que se asigna a la variable resultados.
                        results, i, sweet)) 
                //Este es un método que toma un parámetro de tipo ExecutorService. Ejecuta las tareas que se le envían.        
                .forEach(executor::execute);

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Esperar a que todas las tareas terminen
        }
        //Este es un método que detiene el servicio ejecutor. Detendrá todos los subprocesos y evitará que ejecuten más tareas.
        return IntStream.of(results).sum();
    }
    //Esta es una declaración de clase. Declara una nueva clase llamada CountTask que implementa la interfaz Runnable. La interfaz Runnable se utiliza para crear subprocesos en Java. Un hilo es un proceso que se ejecuta en paralelo con otros procesos. Esto significa que puede ejecutarse al mismo tiempo que otros procesos o subprocesos y compartir recursos con ellos.
    public static class CountTask implements Runnable {
        //Esta es una declaración de variable. Declara una matriz de objetos de tipo Fruit.
        private final Fruit[] fruits;
        //Esta es una declaración de variable. Declara una variable entera llamada start.
        private final int start;
        //Esta es una declaración de variable. Declara una variable entera llamada end.
        private final int end;
        //Esta es una matriz int final privada. Almacena el resultado de la operación de conteo.
        private final int[] results;
        //Esta es una declaración de variable. Declara un entero llamado index y lo establece en el valor de private final int.
        private final int index;
        //Esta es una declaración de variable. Declara una variable booleana privada llamada sweet.
        private final boolean sweet;

        /**
         * @param animals
         * @param start
         * @param end
         * @param results
         * @param index
         * @param sweet
         */
        //Este es un constructor para la clase CountTask. Toma 6 parámetros y los asigna a variables en la clase.
        public CountTask(Fruit[] fruits, int start, int end, int[] results, int index, boolean sweet) {
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this._fruits.
            this.fruits = fruits;
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this.start.
            this.start = start;
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this.end.
            this.end = end;
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this.results.
            this.results = results;
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this.index.
            this.index = index;
            //Este es un constructor. Toma una matriz de objetos de tipo Fruit y la asigna a la variable this.sweet.
            this.sweet = sweet;
        }
        //Este es el método principal del programa. Es donde comienza y termina.
        @Override
        //Este es un método que se ejecuta cuando se inicia el programa
        public void run() {
            //Esta es una declaración de variable. Declara una variable entera llamada count y la inicializa a 0.
            int count = 0;
             //Este es un bucle for. Recorre la variedad de frutas y cuenta cuántas son dulces o amargas.
            for (int i = start; i < end; i++) {
                //Esta es una declaración condicional. Comprueba si el valor de frutas[i].dulce()es igual al valor de dulce. Si es así, ejecutará el código dentro de las llaves. De lo contrario, omitirá ese código y continuará ejecutando lo que venga después de esta declaración condicional.
                if (fruits[i].sweet() == sweet) {
                    //Esta es una declaración que incrementa el valor de la variable cuenta en 1.
                    count++;
                }
            }
            //Esta es una declaración que asigna el valor de recuento al elemento en la matriz results en el índice index.
            results[index] = count;
        }

    }
}