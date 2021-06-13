// 以下に必要な記述を追加せよ
// 以下の記述は例であるため，変更してもよい

import java.util.Scanner;
import java.io.File;

class Dictionary{
    private int wordNum = 46725;
    private String[] wordE = new String[46725];
    private String[] wordJ = new String[46725];
    
    

    public Dictionary(String filename){
	
        try{
	    Scanner scan = new Scanner(new File(filename));
	    for (int i=0;i<wordNum;i++){
		if (!scan.hasNextLine()){
		    // 次の行が読み込めない場合の処理
		    // 辞書ファイルが想定よりも短い場合に実行
		    // 通常は実行されない
		    break;
		}
		String line = scan.nextLine();
		// line には1行全ての文字が含まれるため
		// 英単語と和訳に適切に分割して格納すること
		// 以下に記述を追加
		int space =line.indexOf("\t");;
		wordE[i] = line.substring(0,space);
		wordJ[i] = line.substring(space+1,line.length());
	        

		// これは行が読み込めているかどうかを確認するための表示
		// 不要なので実際の処理では削除するこ
	    }
	}catch(java.io.FileNotFoundException e){
	 System.out.println(e);
	 System.exit(0);
	}
    }
    // 以下に Dictionary クラスで指定されたメソッドを追加すること
    public String searchEWord(String word){
	String s = null;
	for(int i=0; i<wordE.length; i++){
	    if(word.equals(wordE[i])){
		s = wordE[i]+":"+wordJ[i]+"\n";
	    }
	}
	return s;
    }
    
    public String searchFEWord(String word){
	String s = null;
	for(int i=0; i<wordE.length; i++){
	    if(word.startsWith(wordE[i])){
		s ="";
		s += word.replaceFirst(wordE[i],wordE[i]+"-")+":"+wordJ[i]+"\n";
	    }
	
	}
	return s;
    }
    public String searchJWord(String word){
        String s = "";
	for(int i=0; i<wordJ.length; i++){
	    if(wordJ[i].indexOf(word)>=0){
		s +=  wordE[i]+':'+wordJ[i]+"\n";
	    }
	}
	return s;
    }
	
}

public class DictionaryTester{


    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);
        Dictionary x = new Dictionary("ejdic-hand-utf8.txt");

	System.out.print("英単語を入力してください\t");
	System.out.print("英単語:");   String a = stdIn.next();
	System.out.println(a+"を検索します(searchEword)");
	if(x.searchEWord(a)!=null)
	    System.out.println(x.searchEWord(a));
	else
	    System.out.println("見つかりません") ;
	   
	System.out.println();
	
	System.out.print("英熟語を入力してください\t");
	System.out.print("英単語:");   String b = stdIn.next();
	System.out.println(b+"を検索します(searchFEWord)");
        if(x.searchFEWord(b)!=null)
	    System.out.println(x.searchFEWord(b));
	else
	    System.out.println("見つかりません") ;
	System.out.println();

	System.out.print("単語を入力してください\t");
	System.out.print("単語:");    String c = stdIn.next();
	System.out.println(c+"を検索します(searchJWord)");
        if(x.searchJWord(c)!=null)
	    System.out.println(x.searchJWord(c));
	else
	    System.out.println("見つかりません") ;
	System.out.println();

    }
}
