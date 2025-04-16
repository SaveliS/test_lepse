import java.util.stream.Stream;

public class Task3 {
    
    public void start(String line){
        StringBuilder builder = new StringBuilder();
        String word = "";
        String [] words = line.split("_");

        if(Stream.of(words).anyMatch(w -> !w.isEmpty() && Character.isUpperCase(w.charAt(0)))){
            System.out.println("\"" + line + "\" -> \"" + "Error!" + "\"");
            return;
        }

        if(words.length == 1){
            String oldLine = line;
            builder.append(line);
            for (int i = 0; i < line.length(); i++) {
                if(Character.isUpperCase(line.charAt(i))){
                    builder.insert(i, "_");
                    builder.setCharAt(i + 1, Character.toLowerCase(line.charAt(i)));
                    line = builder.toString();
                    i++;
                }
            }
            System.out.println("\"" + oldLine + "\" -> \"" + builder.toString() + "\"");
            return;
        }

        for (int i = 1; i < words.length; i++) {
            char [] chars = words[i].toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            words[i] = String.valueOf(chars);
        }

        System.out.println("\"" + line + "\"" + " -> " + "\"" + String.join(word, words) + "\"");
    }
}
