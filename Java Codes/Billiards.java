/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 4 - Bilhar
 * Data: 08/05/2017
 *
 * Baseado em:
        - BouncingBall.java
        - MouseFollower.java
        - OneSimpleAttractor.java
        (todos disponibilizados no Sandbox da disciplina)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/


public class Billiards
{
    public static void main(String[] args)
    {
        double rx = 0.0, ry = 0.0;
        double dx = 0.0, dy = 0.0, ds = 0.0;
        double vx = 0.0, vy = 0.0;
        double radius = 0.05;
        double massa = 1.25;
        double dt = 0.5;
        double forçaDeAtração = 0.01;
        double atrito = 0.035;
        double fx = 0;
        double fy = 0;

        //optei por estabelecer uma escala cartesiana com quatro quadrantes;
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        StdDraw.enableDoubleBuffering();

        while (true)
        {

            boolean branco = false;

            if (StdDraw.mousePressed()){

                boolean tx, ty; ///auxiliares na determinação do sentido da força de acordo com as posições da bola e do mouse
                branco = true;

                ///distância em x
                if (StdDraw.mouseX() >= rx)
                {
                     if ((StdDraw.mouseX() >= 0 && rx >= 0) || (StdDraw.mouseX() < 0 && rx < 0))
                         dx = Math.abs(StdDraw.mouseX()) - Math.abs(rx);
                    else
                        dx = Math.abs(StdDraw.mouseX()) + Math.abs(rx);

                    tx = false;
                }
                else {
                    if ((StdDraw.mouseX() >= 0 && rx >= 0) || (StdDraw.mouseX() < 0 && rx < 0))
                        dx = Math.abs(rx) - Math.abs(StdDraw.mouseX());
                    else
                        dx = Math.abs(rx) + Math.abs(StdDraw.mouseX());

                    tx = true;
                }
                ///

                ///distância em y
                if (StdDraw.mouseY() >= ry){
                    if ((StdDraw.mouseY() >= 0 && ry >= 0) || (StdDraw.mouseY() < 0 && ry < 0))
                        dy = Math.abs(StdDraw.mouseY()) - Math.abs(ry);
                    else
                        dy = Math.abs(StdDraw.mouseY()) + Math.abs(ry);

                    ty = false;
                }
                else{
                    if ((StdDraw.mouseY() >= 0 && ry >= 0) || (StdDraw.mouseY() < 0 && ry < 0))
                        dy = Math.abs(ry) - Math.abs(StdDraw.mouseY());
                    else
                        dy = Math.abs(ry) + Math.abs(StdDraw.mouseY());

                    ty = true;
                }
                ///

                ///determinação das forças com sentidos coerentes
                if (tx) fx = ((1/dx) * (1/dx) * forçaDeAtração);
                else fx = -((1/dx) * (1/dx) * forçaDeAtração);

                if (ty) fy = ((1/dy) * (1/dy) * forçaDeAtração);
                else fy = -((1/dy) * (1/dy) * forçaDeAtração);

                //auxiliares na detecção de clique em cima da bolinha
                boolean a = false, b = false;

                ///cliques paralelos (com margem de erro de 10% pra mais sob o raio da bolinha - pra evitar super velocidades desproporcionais)
                if(((StdDraw.mouseY() < (ry + 1.1*radius) && StdDraw.mouseY() > (ry - 1.1*radius)) && ((StdDraw.mouseY() >= 0 && ry >= 0)))
                 || ((StdDraw.mouseY() < 0 && ry < 0) && (StdDraw.mouseY() < (ry + 1.1*radius)) && (StdDraw.mouseY() > (ry - 1.1*radius))))
                {
                    fy = 0;
                    a = true;
                }

                if(((StdDraw.mouseX() < (rx + 1.1*radius) && StdDraw.mouseX() > (rx - 1.1*radius)) && ((StdDraw.mouseX() >= 0 && rx >= 0)))
                 || ((StdDraw.mouseX() < 0 && rx < 0) && (StdDraw.mouseX() < (rx + 1.1*radius)) && (StdDraw.mouseX() > (ry - 1.1*radius))))
                {
                    fx = 0;
                    b = true;
                }

                if (a && b) {fx = 0.0; fy = 0.0;} //clique em cima da bolinha = ignora

            }
            else
            {
                ///perda de velocidade
                fx = -(atrito * vx);
                fy = -(atrito * vy);
            }

            ///variação de velocidade
            vx += fx * dt / massa;
            vy += fy * dt / massa;

            ///mudança de posição
            rx += vx * dt;
            ry += vy * dt;


            ///laterais da mesa
            if (Math.abs(rx) + radius > 1.0){
                vx = -vx;
                rx += vx * dt;
            }
            if (Math.abs(ry) + radius >  1.0){
                vy = -vy;
                ry += vy * dt;
            }

            ///posicionar bolinha
            StdDraw.clear();
            if (branco) StdDraw.setPenColor(StdDraw.WHITE);
            else StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(10);
        }

    }
}