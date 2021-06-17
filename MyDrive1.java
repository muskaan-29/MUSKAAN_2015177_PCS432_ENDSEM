import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

// file system 
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

// box classes import 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

// mapreduce imports
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDrive1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration conf = new Configuration();
		Job j = new Job(conf, "Prime Sum");
		j.setJarByClass(MyDrive1.class);
		j.setMapperClass(MyMap1.class);
		j.setReducerClass(MyReduce1.class);
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));

		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}
}
