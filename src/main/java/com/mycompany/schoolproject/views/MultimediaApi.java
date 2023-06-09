package com.mycompany.schoolproject.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import com.mycompany.schoolproject.Schoolproject;

public class MultimediaApi {
    public void config(JFrame root)
    {
        
        String rootRoute = System.getProperty("user.dir");
        rootRoute = rootRoute + "\\src\\main\\java\\com\\mycompany\\schoolproject\\files\\icono.png";
        Image icono = Toolkit.getDefaultToolkit().getImage(rootRoute); 
        root.setTitle("Aula 360°");
        root.setIconImage(icono);
        root.setResizable(false);
        root.getContentPane().setBackground(Color.white);
        root.setLayout(null);
    }
    
    public void configPanelTop(JFrame root)
    {
        // Definimos el tamaño de la venta que se ingresa por parametros 
        root.setSize(769, 500);
        // Se instancia panel y se agrega las siguientes confiraciones
        /*
        1. color
        2. dimension
        3. le retiramos el layout para ordenar por coordenadas
        */
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 765, 55);
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        
        /*
        Se instancian tres JLabels del menú 
        1. Asignamos dos litas una que guardas los labels y otra que guarda el nombre de las imagenes 
        */
        JLabel menuOptions = new JLabel();
        JLabel logo = new JLabel();
        JLabel outside = new JLabel();
        JLabel[] labels = {menuOptions, logo, outside}; 
        String[] images = {"menu45x45.png", "iconInicio45x45.png", "outside.png"};
        
        /*
        DOM para el menu de navegaciòn, y generar interaciòn  
        */
        // DOM para desplegar opciones 
        menuOptions.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Acción a realizar cuando se hace clic en el JLabel
                System.out.println("Desplegar opciones");
            }
        });
        
        // DOM para volver a inicio
        logo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Acción a realizar cuando se hace clic en el JLabel
                System.out.println("Volver a inicio");
            }
        });
        
        // DOM para salir de la interfaz
        outside.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Acción a realizar cuando se hace clic en el JLabel
                Schoolproject school = new Schoolproject();
                school.instanceLogin().intercambioVentana(school);
            }
        });
        
        
        /*
        1. array de coordenadas sobre cada label encima del panel 
        */
        int[][] arrayCordenadas = {{15, 5, 45, 45},{360, 5, 45, 45},{700, 5, 45, 45}};
        
        // Definimos el contador de el array de coordenadas y de las imagenes, para recorres el array
        int count = 0;
        
        // Definimos una variable root que va a almacenar la ruta de la imagen
        String route;
        
        // Recorremos cada label y lo configuramos 1 a 1 
        for (JLabel label: labels ) 
        {
            // definimos el vecotr de cordenadas especifico del label
            int[] vector = arrayCordenadas[count];
            // Le damos las cordenada definidas al label
            /*
            Loa vectores se estructuran de la siguiente manera
            ventor 0 -> pocision en x
            vector 1 -> pocision en y
            vector 2 -> tamaño width
            vector 3 -> tamaño en height 
            */
            label.setBounds(vector[0], vector[1], vector[2],vector[3]);
            
            // después de configurar cada label se le agrega al panel 
            panel.add(label);
            // Traemos toda la ruta hasta el directorio de trabajo
            route = System.getProperty("user.dir");
            //les agregamos una imagen a cada label con la ruta de cada imagen 
            /*
            La estructura de la url es de la siguiente manera 
            1. route -> significa carpeta de desarrollo quiere decir se para sobre "schoolproject"
            2. ruta de la imagen 
            3. la variable de la imagen especifica 
            */
            label.setIcon(new javax.swing.ImageIcon(route + "\\src\\main\\java\\com\\mycompany\\schoolproject\\files\\" + images[count]));
            // aumentamos el contador para escalar el array de imagenes y cordenada a la par 
            count += 1;
        }
        // agregamos el panel al frame principal
        root.getContentPane().add(panel);
        // empaquetamos el panel y se guarda el cambio 
        root.pack();
        
    }
    
    public void privateData(JFrame frame, LinkedHashMap<String, String> dataUser)
    {
        // definimos la variable que ordenara el texto
        String textoData = ""; 
        // Hacemos un iterador sobre los dato y vamos armando el texto
        for(String llave: dataUser.keySet())
        {
            textoData += llave + " : " + dataUser.get(llave) + "\n";
        }
        // definimos el text area donde se mostrara los datos por pantalla
        JTextArea texto = new JTextArea();
        // agregamos el texto, ordenado 
        texto.append(textoData);
        // Hacemos que el textarea nose pueda editar
        texto.setEditable(false);
        // definimos la coordenada donde ira el text area en el frame 
        texto.setBounds(550, 260, 180, 205);
        // le definimos una fuente 
        Font fuente = new Font("Arial", Font.BOLD, 12);
        texto.setFont(fuente);// agregamos la fuente 
        // le mandamos el text area al frame 
        frame.getContentPane().add(texto);
        //empaquetamos el texto a la pantalla 
        frame.pack();
    }
    
    // Esta funcion recibe dos parametros recibe los paneles de los dias y recibe un Map que me da los dias, con sus horas y materias 
    public void schuldleOrganice(JPanel[] arrayPanel, LinkedHashMap<String, LinkedHashMap<Integer, String>> schuldle)
    {
        // Definimos los dias que iran en los Labels
        String[] days = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        // contador de la lista dias 
        int count = 0; 
        // itera los paneles para agregales las funcionalidades 
        for(JPanel panel: arrayPanel){
            // Se define la fuente de los label
            Font font = new Font("sielf", Font.BOLD, 12);
            // Esta variable guardara el dia y se ira cambiando a medida que el contador aumente 
            String day = days[count];
            // Definimos un label que tendra como texto el dia 
            JLabel label = new JLabel(day);
            // le damos un estilo a la letra 
            label.setFont(font);
            // Se el dan las coordenadas al label de que pocision llevara 
            label.setBounds(20, 0, 70, 40);
            // Agregamos al panel el label, -> las configuraciones ya las tiene el label
            panel.add(label);
            // Aumentamos el contador 
            count++;
            // Convertimos el dia a minuscula para usarlo como clave en el Map  
            day = day.toLowerCase();
            // Definimos las cordenadas y tamaños, y lo usaremos de la siguiente manera 
            /*
            1. Cada dia tiene 6 horas y materias, cada hora se almacenara en un label
            2. con las cooredenada le damos coordenada X y Y y le añadimos un width y height
            3. Dejamos el array predefinido y se itera con un contador 
            */
            int coordenates[][] = {
                {0, 40, 85, 40},
                {0, 80, 85, 40},
                {0, 120, 85, 40},
                {0, 160, 85, 40},
                {0, 200, 85, 40}, 
                {0, 240, 85, 40}
            };
            // iterador de las coordenadas
            int position = 0; 
            // Realizamos un for sobre el map iterando sus llaves que son interador osea las horas de 1 -> 6
            for(Integer key : schuldle.get(day.toLowerCase()).keySet())
            {
                // Asinamos al label su hora y al lado materia y lo condensamos en un label que se mostrara
                JLabel info = new JLabel(key + " : " + schuldle.get(day.toLowerCase()).get(key));
                // le damos un font
                info.setFont(font);
                // le damos la pocision apoyandonos en el array de coordenadas 
                info.setBounds(coordenates[position][0], coordenates[position][1], coordenates[position][2], coordenates[position][3]);
                // aumentamos pocision para que itere el array de coordenadas 
                position++;
                // Añadimos el label al panel 
                panel.add(info);
            }
        }
        
        
    }
            
}                    
