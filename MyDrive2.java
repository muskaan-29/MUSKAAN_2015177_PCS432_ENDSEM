//exception handling
import java.io.IOException;

// importing file system 
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

// importing box classes  
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

//importing  mapreduce 
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDrive2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException 
{

		Job j = new Job();
		j.setJobName("frequency counter");
		j.setJarByClass(MyDrive2.class);
		j.setMapperClass(MyMap2.class);
		j.setReducerClass(MyReduce2.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));

		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}

}