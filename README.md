# Multithreading
Viewed such topics as Java memory model, monitor, synchronized, java.util.concurrent, ReentrantLock,
BlockingQueue, ConcurrentHashMap, atomics, Runnable, Callable, Future, ThreadPoolExecutor, streams, lambdas.
## Tasks
### Первая задача о Винни-Пухе или неправильные пчелы
`src\labs\task_about_bear_or_wrong_bees\BearAndWrongBees.java`<br>
Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха, решили разыскать его и
наказать в назидание всем другим любителям сладкого. Для поисков медведя они поделили лес на участки, каждый
из которых прочесывает одна стая неправильных пчел. В случае нахождения медведя на своем участке стая
проводит показательное наказание и возвращается в улей.
Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
Требуется создать многопоточное приложение, моделирующее действия пчел.
При решении использовать парадигму портфеля задач.
### Первая военная задача
`src\labs\army\Army.java`<br>
Темной-темной ночью прапорщики Иванов, Петров и Нечепорчук занимаются хищением военного имущества со склада
родной военной части. Будучи умными людьми и отличниками боевой и строевой подготовки, прапорщики ввели
разделение труда: Иванов выносит имущество со склада, Петров грузит его в грузовик, а Нечепорчук
подсчитывает рыночную стоимость добычи. Требуется составить многопоточное приложение, моделирующее
деятельность прапорщиков. При решении использовать парадигму «производитель-потребитель» с активным ожиданием.
### Задача о Винни-Пухе или правильные пчелы
`src\labs\bear_and_bees`<br>
В одном лесу живут n пчел и один медведь, которые используют один горшок меда, вместимостью N глотков.
Сначала горшок пустой. Пока горшок не наполнится, медведь спит. Как только горшок заполняется,
медведь просыпается и съедает весь мед, после чего снова засыпает. Каждая пчела многократно собирает
по одному глотку меда и кладет его в горшок. Пчела, которая приносит последнюю порцию меда, будит медведя.
Создать многопоточное приложение, моделирующее поведение пчел и медведя.
### Задача о парикмахере
`src\labs\hairdresser\HairdresserTask.java`<br>
В тихом городке есть парикмахерская. Салон парикмахерской мал, ходить там может только парикмахер и один
посетитель. Парикмахер всю жизнь обслуживает посетителей. Когда в салоне никого нет, он спит в кресле.
Когда посетитель приходит и видит спящего парикмахера, он будит его, садится в кресло и спит, пока
парикмахер занят стрижкой. Если посетитель приходит, а парикмахер занят, то он встает в очередь и засыпает.
После стрижки парикмахер сам провожает посетителя. Если есть ожидающие посетители,
то парикмахер будит одного из них и ждет пока тот сядет в кресло парикмахера и начинает стрижку.
Если никого нет, он снова садится в свое кресло и засыпает до прихода посетителя.
Создать многопоточное приложение, моделирующее рабочий день парикмахерской.
### Задача о курильщиках
`src\labs\sigarette_smokers`<br>
Есть три процесса-курильщика и один процесс-посредник. Курильщик непрерывно скручивает сигареты и курит их.
Чтобы скрутить сигарету, нужны табак, бумага и спички. У одного процесса- курильщика есть табак,
у второго – бумага, а у третьего – спички. Посредник кладет на стол по два разных случайных компонента.
Тот процесс-курильщик, у которого есть третий компонент, забирает компоненты со стола, скручивает
сигарету и курит. Посредник дожидается, пока курильщик закончит, затем процесс повторяется.
Создать многопоточное приложение, моделирующее поведение курильщиков и посредника.
При решении задачи использовать концепцию монитора.
### Parallel execution time tracker
`src\labs\parallel_execution_time_tracker\TimeTracker.java`<br>
Write a program that tracks time of parallel execution of N threads. Threads should start together
### Simple executor service
`src\labs\simple_executor_service`<br>
Write your own implementation of executor service
### Play the accordion
`src\labs\PlayTheAccordion`<br>
```java
public class Lab_Thread_Thread_Play_The_Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            // A + B
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();
            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();
            // C
            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            printerC.run();
            System.out.println("-----");
        }
    }
}
```
Modify / add code preserving the functionality, but increasing the number of threads. There are three threads:
1) thread of method `main()`
2) `ThreadA`
3) `ThreadB`
You need to add threads threadC and threadCoordinator:
4) in threadC from `main()` method, take out printing of letter 'C'
5) in threadCoordinator take out from the `main()` method the functional of creation,
start and waiting for threads threadA + threadB + threadC completion.
The general scenario should be as follows:
- thead of `main()` method creates, starts and waits for threadCoordinator to end
- Thread threadCoordinator cyclically creates, starts threads threadA and threadB (they work simultaneously),
 waits for them to end, after this creates, starts and waits for the threadC thread to end.
### Rabbit attack
`src\labs\RabbitAttack`<br>
Modify / add code: now the thread in which `main()` method works cyclically ejects theads - "signal rockets",
they write 10 times to console and die. There is asymmetry (main - generates, Printer - prints).
Make a new class `RabbitPrinter`, which writes to the console and cyclically generates
every second a new RabbitPrinter.
```java
public class Lab_Thread_Thread_Rabbit_Attack {

    public static void main(String[] args) throws InterruptedException {
        for (int k = 1; k < 10000000; k++) {
            String spaces = spaces(k);
            Runnable printer = new PrintRunnable(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }

    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}
```
