package algorithms;

/**
 * @author AlanViast
 */
public class Statistics {

    public static void main(String[] args) {
        Comparable[] arr = Utils.randomArrays(10000);
        Selection selection = new Selection();
        selection.run(arr.clone());

        Insertion insertion = new Insertion();
        insertion.run(arr.clone());

        Shell shell = new Shell();
        shell.run(arr.clone());

        Merge merge = new Merge();
        merge.run(arr.clone());

        MergeBu mergeBu = new MergeBu();
        mergeBu.run(arr.clone());

        Quick quick = new Quick();
        quick.run(arr.clone());
    }
}
