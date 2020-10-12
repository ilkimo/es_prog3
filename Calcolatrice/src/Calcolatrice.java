import java.util.List;

public class Calcolatrice {

    public static void print(List<? extends Number> lista){
        System.out.print("[");
        for(Number n : lista){
            System.out.print(n + ", ");
        }
        System.out.println("]");
    }

    public static Number sum(List<? extends Number> lista){

        if(lista!=null && lista.size()>0) {
            Class first_class = lista.get(0).getClass();
            //System.out.println(first_class.getName());

            switch(first_class.getName()){
                case "java.lang.Integer": {
                    int sum = 0;
                    for (Number n : lista) {
                        sum += (Integer) n;
                    }
                    return sum;
                }
                case "java.lang.Double": {
                    double sum = 0;
                    for (Number n : lista) {
                        sum += (Double) n;
                    }
                    return sum;
                }
                case "java.lang.Float": {
                    float sum = 0;
                    for (Number n : lista) {
                        sum += (Float) n;
                    }
                    return sum;
                }
                case "java.lang.Long": {
                    long sum = 0;
                    for (Number n : lista) {
                        sum += (Long) n;
                    }
                    return sum;
                }
                default:
                    break;
            }
        }

        return null;
    }

    public static Number max(List<? extends Number> lista) {
        if (lista != null && lista.size() > 0) {

            Class c = (lista.get(0)).getClass();
            switch (c.getName()) {
                case "java.lang.Integer": {
                    int max = lista.get(0).intValue();
                    for (Number n : lista) {
                        if (n.intValue() > max) {
                            max = n.intValue();
                        }
                    }
                    return max;
                }
                case "java.lang.Double": {
                    double max = lista.get(0).doubleValue();
                    for (Number n : lista) {
                        if (n.doubleValue() > max) {
                            max = n.doubleValue();
                        }
                    }
                    return max;
                }
                case "java.lang.Float": {
                    float max = lista.get(0).floatValue();
                    for (Number n : lista) {
                        if (n.floatValue() > max) {
                            max = n.floatValue();
                        }
                    }
                    return max;
                }
                case "java.lang.Long": {
                    long max = lista.get(0).longValue();
                    for (Number n : lista) {
                        if (n.longValue() > max) {
                            max = n.longValue();
                        }
                    }
                    return max;
                }
            }
        }
        return null;

        //compare alternativo: non completo
        /*
        public static Number compare(Number o, Number b) {
            Class first_class = o.getClass();
            //System.out.println(first_class.getName());

            switch(first_class.getName()){
                case "java.lang.Integer": {
                    return (Integer)o-(Integer)b;
                }
                case "java.lang.Double": {
                    return (Double)o-(Double)b;
                }
                case "java.lang.Float": {
                    return (Float)o-(Float)b;
                }
                case "java.lang.Long": {
                    if((Long)o<0 && (Long)b<0){
                        if(-(Long)o<-(Long)b){
                            System.out.println(o);
                            return o;
                        }else{
                            System.out.println(b);
                            return b;
                        }
                    }else if((Long)o>0 && (Long)b>0){
                        return (Long)o-(Long)b;
                    }else{
                        if((Long)o>0){
                            System.out.println(o);
                            return o;
                        }else{
                            System.out.println(b);
                            return b;
                        }
                    }
                }
                default:
                    break;
            }
            return null;
        }
         */
    }
}
