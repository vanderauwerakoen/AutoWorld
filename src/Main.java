import be.vdab.schoolferief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.voertuigen.PersonenWagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuigen;
import be.vdab.voertuigen.Vrachtwagen;
import be.vdab.voertuigen.div.Maat;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

import static be.vdab.voertuigen.div.Maat.meter;

public class Main {
    public static void main(String[] args) throws IOException {

        SortedSet<Voertuigen> set = new TreeSet<Voertuigen>();
        Voertuigen wagen1 = new PersonenWagen("Golf", BigDecimal.valueOf(25000), 4);
        Voertuigen wagen2 = new PersonenWagen("Kia", BigDecimal.valueOf(17000), 4);
        Volume laadbaar = new Volume(10, 20, 30, meter);
        Voertuigen pickup = new Pickup("Mercedes", BigDecimal.valueOf(45000), 4, laadbaar);
        Volume laadbaar2 = new Volume(20, 30, 30, meter);
        Voertuigen pickup2 = new Pickup("Golf", BigDecimal.valueOf(35000), 4, laadbaar);
        Voertuigen vracht = new Vrachtwagen("DAF", BigDecimal.valueOf(45000), laadbaar, 5000, 3);
        Voertuigen vracht2 = new Vrachtwagen("DAF", BigDecimal.valueOf(45000), laadbaar, 5000, 3);
        set.add(pickup);
        set.add(pickup2);
        set.add(vracht);
        set.add(vracht2);
        set.add(wagen1);
        set.add(wagen2);


        set.stream().forEach(System.out::println);

        File newFile = new File("C:/Users/Koen/data/punt.ser");
        try {
            newFile.getParentFile().mkdirs();
            boolean success = newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var stream =
                     new ObjectOutputStream(Files.newOutputStream(
                             Path.of(newFile.getPath())))
        ) {


            var punt = set;
            stream.writeObject(punt);

        } catch (IOException ex) {
            System.out.println(ex);
        }
        try (var stream =
                     new ObjectInputStream(Files.newInputStream(
                             Path.of(newFile.getPath())))
        ) {



            SortedSet<Voertuigen> o = (TreeSet)  stream.readObject();
            o.stream().forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Boekentas tas=new Boekentas(new Volume(3,5,7, meter),"groen");
        Boekentas tas1=new Boekentas(new Volume(7,5,7, meter),"blauw");
        Boekentas tas2=new Boekentas(new Volume(8,5,7, meter),"rood");
        Boekentas tas3=new Boekentas(new Volume(3,5,7, meter),"zwart");
        Boekentas tas4=new Boekentas(new Volume(3,5,7, meter),"geel");

        System.out.println("Boekentas objecten:");
        var tassen=new Boekentas[5];
        tassen[0]=tas;
        tassen[1]=tas1;
        tassen[2]=tas2;
        tassen[3]=tas3;
        tassen[4]=tas4;
        Arrays.stream(tassen).forEach(System.out::println);





        Laadbaar[] instances=new Laadbaar[6];
        instances[0]=tas2;
        instances[1]=tas4;
        instances[2]=tas;
        instances[3]=(Pickup)pickup;;
        instances[4]=(Pickup)pickup2;
        instances[5]=(Vrachtwagen)vracht2;
        Optional<Double> sum = Optional.of(Arrays.stream(instances).peek(System.out::println).mapToDouble(v -> {
                    var aDouble = v.getLaadvolume().getVolume();
                    return aDouble;
                })
                .sum());
        sum.ifPresent(s->{ int sInt=s.intValue();System.out.println(String.format("laad som van de volumes:%d",sInt));});

    }
}