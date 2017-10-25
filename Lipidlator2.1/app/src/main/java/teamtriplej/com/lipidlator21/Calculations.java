package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017
 */

class Calculations {
    private double mass;
    private int numC, numH, numN, numO, numAg, numLi, numNa, numK, numCl, numP, numS, numF;
    private double[] ratioValues = {28.02908,2,4,56.06038,4,8,84.09168,6,12,112.12298,8,16,
            140.15428,10,20,168.18558,12,24,182.20123,13,26,
            196.21688,14,28,194.20123,14,26,210.23253,15,30,
            208.21688,15,28,224.24818,16,32,222.23253,16,30,
            238.26383,17,34,236.24818,17,32,234.23253,17,30,
            252.27948,18,36,250.26383,18,34,250.26383,18,34,
            248.24818,18,32,246.23253,18,30,246.23253,18,30,
            244.21688,18,28,266.29513,19,38,280.31078,20,40,
            278.29513,20,38,276.27948,20,36,274.26383,20,34,
            272.24818,20,32,270.23253,20,30,294.32643,21,42,
            308.34208,22,44,306.32643,22,42,304.31078,22,40,
            302.29513,22,38,300.27948,22,36,298.26383,22,34,
            296.24818,22,32,322.35773,23,46,336.37338,24,48,
            334.35773,24,46,350.38903,25,50,364.40468,26,52};
    Calculations() {
    }
    String calculateFormula(int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {
        String SUB_ZERO = "\u2080";String SUB_FIVE = "\u2085";
        String SUB_ONE = "\u2081";String SUB_SIX = "\u2086";
        String SUB_TWO = "\u2082";String SUB_SEVEN = "\u2087";
        String SUB_THREE = "\u2083";String SUB_EIGHT = "\u2088";
        String SUB_FOUR = "\u2084";String SUB_NINE = "\u2089";
        String formula = "C" + numC + "H" + numH;
        if(numN == 1){formula+= "N";} else if(numN > 1){formula+= "N"+numN;}
        if(numO == 1){formula+= "O";} else if(numO > 1){formula+= "O"+numO;}
        if(numP == 1){formula+= "P";} else if(numP > 1){formula+= "P"+numP;}
        if(numS == 1){formula+= "S";} else if(numS > 1){formula+= "S"+numS;}
        if(numAg == 1){formula+= "Ag";} else if(numAg > 1){formula+= "Ag"+numAg;}
        if(numLi == 1){formula+= "Li";} else if(numLi > 1){formula+= "Li"+numLi;}
        if(numNa == 1){formula+= "Na";} else if(numNa > 1){formula+= "Na"+numNa;}
        if(numK == 1){formula+= "K";} else if(numK > 1){formula+= "K"+numK;}
        if(numCl == 1){formula+= "Cl";} else if(numCl > 1){formula+= "Cl"+numCl;}
        if(numF == 1){formula+= "F";} else if(numF > 1){formula+= "F"+numF;}
        String newFormula = formula.replaceAll("0", SUB_ZERO).replaceAll("1", SUB_ONE)
                .replaceAll("2", SUB_TWO).replaceAll("3", SUB_THREE).replaceAll("4", SUB_FOUR)
                .replaceAll("5", SUB_FIVE).replaceAll("6", SUB_SIX).replaceAll("7", SUB_SEVEN)
                .replaceAll("8", SUB_EIGHT).replaceAll("9", SUB_NINE);
        return newFormula;
    }
    double calculateFABasicMass(int massIndex, int esterIndex)
    {
        double[] esterArray1 = {60.021130,2,4,88.052430,4,8,116.083730,6,12,
                144.115030,8,16,172.146330,10,20,200.177630,12,24,
                214.193280,13,26,228.208930,14,28,226.193280,14,26,
                242.224580,15,30,240.208930,15,28,256.240230,16,32,
                254.224580,16,30,270.255880,17,34,268.240230,17,32,
                266.224580,17,30,284.271530,18,36,282.255880,18,34,
                282.255880,18,34,280.240230,18,32,278.224580,18,30,
                278.224580,18,30,276.208930,18,28,298.287180,19,38,
                312.302830,20,40,310.287180,20,38,308.271530,20,36,
                306.255880,20,34,304.240230,20,32,302.224580,20,30,
                326.318480,21,42,340.334130,22,44,338.318480,22,42,
                336.302830,22,40,334.287180,22,38,332.271530,22,36,
                330.255880,22,34,328.240230,22,32,354.349780,23,46,
                368.365430,24,48,366.349780,24,46,382.381080,25,50,
                396.396730,26,52};
        double[] esterArray2 = {74.036780,3,6,102.068080,5,10,130.099380,7,14,
                158.130680,9,18,186.161980,11,22,214.193280,13,26,
                228.208930,14,28,242.224580,15,30,240.208930,15,28,
                256.240230,16,32,254.224580,16,30,270.255880,17,34,
                268.240230,17,32,284.271530,18,36,282.255880,18,34,
                280.240230,18,32,298.287180,19,38,296.271530,19,36,
                296.271530,19,36,294.255880,19,34,292.240230,19,32,
                292.240230,19,32,290.224580,19,30,312.302830,20,40,
                326.318480,21,42,324.302830,21,40,322.287180,21,38,
                320.271530,21,36,318.255880,21,34,316.240230,21,32,
                340.334130,22,44,354.349780,23,46,352.334130,23,44,
                350.318480,23,42,348.302830,23,40,346.287180,23,38,
                344.271530,23,36,342.255880,23,34,368.365430,24,48,
                382.381080,25,50,380.365430,25,48,396.396730,26,52,
                410.412380,27,54};
        double[] esterArray3 = {240.020970,9,5,268.052270,11,9,296.083570,13,13,
                324.114870,15,17,352.146170,17,21,380.177470,19,25,394.193120,20,27,
                408.208770,21,29,406.193120,21,27,422.224420,22,31,420.208770,22,29,
                436.240070,23,33,434.224420,23,31,450.255720,24,35,448.240070,24,33,
                446.224420,24,31,464.271370,25,37,462.255720,25,35,462.255720,25,35,
                460.240070,25,33,458.224420,25,31,458.224420,25,31,456.208770,25,29,
                478.287020,26,39,492.302670,27,41,490.287020,27,39,488.271370,27,37,
                486.255720,27,35,484.240070,27,33,482.224420,27,31,506.318320,28,43,
                520.333970,29,45,518.318320,29,43,516.302670,29,41,514.287020,29,39,
                512.271370,29,37,510.255720,29,35,508.240070,29,33,534.349620,30,47,
                548.365270,31,49,546.349620,31,47,562.380920,32,51,576.396570,33,53};
        if(esterIndex == 0){
            setMass(esterArray1[(massIndex * 3)]);
            setNumC((int)esterArray1[(massIndex * 3)+1]);
            setNumH((int)esterArray1[(massIndex * 3)+2]);
            setNumO(2);
        }else if(esterIndex == 1){
            setMass(esterArray2[(massIndex * 3)]);
            setNumC((int)esterArray2[(massIndex * 3)+1]);
            setNumH((int)esterArray2[(massIndex * 3)+2]);
            setNumO(2);
        }else if(esterIndex == 2){
            setMass(esterArray3[(massIndex * 3)]);
            setNumC((int)esterArray3[(massIndex * 3)+1]);
            setNumH((int)esterArray3[(massIndex * 3)+2]);
            setNumO(2);
            setNumF(5);}
        return getMass();
    }
    double calculateWEBasicMass(int alcoholIndex, int acidIndex)
    {
        double alcohol = ratioValues[(alcoholIndex * 3)];
        int carbonAlcohol = (int)ratioValues[(alcoholIndex * 3) + 1];
        int hydrogenAlcohol = (int)ratioValues[(alcoholIndex * 3) + 2];
        double acid = ratioValues[(acidIndex * 3)];
        int carbonAcid = (int)ratioValues[(acidIndex * 3) + 1];
        int hydrogenAcid = (int)ratioValues[(acidIndex * 3) + 2];
        setMass((alcohol + acid) + 31.99205);
        setNumC(carbonAlcohol + carbonAcid);
        setNumH(hydrogenAlcohol + hydrogenAcid);
        setNumO(2);
        return getMass();
    }
    double calculateACBasicMass(int acylIndex)
    {
        double[] acArray = {203.115759,9,17,231.147059,11,21,259.178359,13,25,287.209659,15,29,
                315.240959,17,33,343.272259,19,37,357.287909,20,39,371.303559,21,41,
                369.287909,21,39,385.319209,22,43,383.303559,22,41,399.334859,23,45,
                397.319209,23,43,413.350509,24,47,411.334859,24,45,409.319209,24,43,
                427.366159,25,49,425.350509,25,47,425.350509,25,47,423.334859,25,45,
                421.319209,25,43,421.319209,25,43,419.303559,25,41,441.381809,26,51,
                455.397459,27,53,453.381809,27,51,451.366159,27,49,449.350509,27,47,
                447.334859,27,45,445.319209,27,43,469.413109,28,55,483.428759,29,57,
                481.413109,29,55,479.397459,29,53,479.397459,29,53,475.366159,29,49,
                473.350509,29,47,471.334859,29,45,497.444409,30,59,511.460059,31,61,
                509.444409,31,59,525.475709,32,63,539.491359,33,65};
        setMass(acArray[(acylIndex * 3)]);
        setNumC((int)acArray[(acylIndex * 3) + 1]);
        setNumH((int)acArray[(acylIndex * 3) + 2]);
        setNumO(4);
        setNumN(1);
        return getMass();
    }
    double calculateCLBasicMass(int index1, int index2, int index3, int index4)
    {
        double carbon = 12.000000;
        double hydrogen = 1.007825;
        double oxygen = 15.994915;
        double phosphorus = 30.973761;
        int cCount = 15;
        int hCount = 26;
        int[] sn1_elements = {2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,28,16,
                34,16,32,16,32,16,30,17,34,17,32,17,30,18,38,18,36,18,36,18,34,18,34,18,32,18,30,
                18,30,18,28,19,38,20,42,20,40,20,40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,
                42,22,40,22,38,22,36,22,34,22,32,23,46,24,48,24,46,25,50,26,52};
        int[] other_sn_elements = {0,0,2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,28,
                16,32,16,30,17,34,17,32,17,30,18,36,18,34,18,34,18,32,18,30,18,30,18,28,19,38,20,
                40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,42,22,40,22,38,22,36,22,34,22,32,
                23,46,24,48,24,46,25,50,26,52};

        setNumC((sn1_elements[index1*2]+other_sn_elements[index2*2]+
                other_sn_elements[index3*2]+other_sn_elements[index4*2])+cCount);
        setNumH((sn1_elements[(index1*2)+1]+other_sn_elements[(index2*2)+1]+
                other_sn_elements[(index3*2)+1]+other_sn_elements[(index4*2)+1])+hCount);
        if(index1 == 11 ||index1 == 12 ||index1 == 18 ||index1 == 19 ||index1 == 28 ||index1 == 29){
            setNumO(16);
        }else{
            setNumO(17);}
        setNumP(2);
        setMass(((getNumC()*carbon)+(getNumH()*hydrogen)+(getNumO()*oxygen)+(getNumP()*phosphorus)));
        return getMass();
    }
    double calculateCoABasicMass(int acylIndex)
    {
        double[] coaArray = {23,38,25,42,27,46,29,50,31,54,33,58,34,60
                ,35,62,35,60,36,64,36,62,37,66,37,64,38,68
                ,38,66,38,64,39,70,39,68,39,68,39,66,39,64,39,64,39,62
                ,40,72,41,74,41,72,41,70,41,68,41,66,41,64,42,76,43,78
                ,43,76,43,74,43,72,43,70,43,68,43,66,44,80,45,82,45,80
                ,46,84,47,86};

        setMass(coaArray[acylIndex * 3]);
        setNumC((int)coaArray[(acylIndex * 3) + 1]);
        setNumH((int)coaArray[(acylIndex * 3) + 2]);
        setNumO(17);
        setNumN(7);
        setNumP(3);
        setNumS(1);

        return getMass();
    }
    double calculateCHEBasicMass(int acylIndex)
    {
        double[] arrayCHE = {428.365430,29,48,456.396730,31,52,484.428030,33,56,
                512.459330,35,60,540.490630,37,64,568.521930,39,68,582.537580,40,70,
                596.553230,41,72,594.537580,41,70,610.568880,42,74,608.553230,42,72,
                624.584530,43,76,622.568880,43,74,638.600180,44,78,636.584530,44,76,
                634.568880,44,74,652.615830,45,80,650.600180,45,78,650.600180,45,78,
                648.584530,45,76,646.568880,45,74,644.553230,45,72,666.631480,46,82,
                680.647130,47,84,678.631480,47,82,676.615830,47,80,674.600180,47,78,
                672.584530,47,76,670.568880,47,74,694.662780,48,86,706.662780,49,86,
                708.678430,49,88,706.662780,49,86,704.647130,49,84,702.631480,49,82,
                700.615830,49,80,698.600180,49,78,696.584530,49,76,722.694080,50,90,
                736.709730,51,92,734.694080,51,90,750.725380,52,94,764.741030,53,96};
        setMass(arrayCHE[acylIndex * 3]);
        setNumC((int)arrayCHE[(acylIndex * 3) + 1]);
        setNumH((int)arrayCHE[(acylIndex * 3) + 2]);
        setNumO(2);
        return getMass();
    }
    double calculateGBasicMass(int g_sn1Index){

        // SN1 Dropdown: 49 values
        // SN2 Dropdown: 44 Values
        // SN3 Dropdown: 44 values
        // # of Possible Combination: 94,864

        // SN1 Changing, SN2 & SN2 = 0:0
        double[] arrayGlycerolipid_sn1 = {134.057910,5,10,4,162.089210,7,14,4,190.120510,9,18,4,
                218.151810,11,22,4,246.183110,13,26,4,274.214410,15,30,4,288.230060,16,32,4,
                302.245710,17,34,4,300.230060,17,32,4,316.261360,18,36,4,314.245710,18,34,4,
                316.297745,19,40,3,314.282095,19,38,3,330.277010,19,38,4,328.261360,19,36,4,
                344.292660,20,40,4,342.277010,20,38,4,340.261360,20,36,4,344.329045,21,44,3,
                342.313395,21,42,3,358.308310,21,42,4,356.292660,21,40,4,356.292660,21,40,4,
                354.277010,21,38,4,352.261360,21,36,4,352.261360,21,36,4,350.245710,21,34,4,
                372.323960,22,44,4,372.360345,23,48,3,370.344695,23,46,3,386.339610,23,46,4,
                384.323960,23,44,4,382.308310,23,42,4,380.292660,23,40,4,378.277010,23,38,4,
                376.261360,23,36,4,400.355260,24,48,4,414.370910,25,50,4,412.355260,25,48,4,
                410.339610,25,46,4,408.323960,25,44,4,406.308310,25,42,4,404.292660,25,40,4,
                402.277010,25,38,4,428.386560,26,52,4,442.402210,27,54,4,440.386560,27,52,4,
                456.417860,28,56,4,470.433510,29,58,4};

        // NOTE: SN2 & SN3 MASS Values = SAME
        double[] arrayGlycerolipid_sn2 = {134.057910,5,10,4,176.068475,7,12,5,204.099775,9,16,5,
                232.131075,11,20,5,260.162375,13,24,5,288.193675,15,28,5,316.224975,17,32,5,
                330.240625,18,34,5,344.256275,19,36,5,342.240625,19,34,5,358.271925,20,38,5,
                356.256275,20,36,5,372.287575,21,40,5,370.271925,21,38,5,386.303225,22,42,5,
                384.287575,22,40,5,382.271925,22,38,5,400.318875,23,44,5,398.303225,23,42,5,
                398.303225,23,42,5,396.287575,23,40,5,394.271925,23,38,5,394.271925,23,38,5,
                392.256275,23,36,5,414.334525,24,46,5,428.350175,25,48,5,426.334525,25,46,5,
                424.318875,25,44,5,422.303225,25,42,5,420.287575,25,40,5,418.271925,25,38,5,
                442.365825,26,50,5,456.381475,27,52,5,454.365825,27,50,5,452.350175,27,48,5,
                450.334525,27,46,5,448.318875,27,44,5,446.303225,27,42,5,444.287575,27,40,5,
                470.397125,28,54,5,484.412775,29,56,5,482.397125,29,54,5,498.428425,30,58,5,
                512.444075,31,60,5};

        double[] arrayGlycerolipid_Sn3 = {134.057910,5,10,4,176.068475,7,12,5,204.099775,9,16,5,
                232.131075,11,20,5,260.162375,13,24,5,288.193675,15,28,5,316.224975,17,32,5,
                330.240625,18,34,5,344.256275,19,36,5,342.240625,19,34,5,358.271925,20,38,5,
                356.256275,20,36,5,372.287575,21,40,5,370.271925,21,38,5,386.303225,22,42,5,
                384.287575,22,40,5,382.271925,22,38,5,400.318875,23,44,5,398.303225,23,42,5,
                398.303225,23,42,5,396.287575,23,40,5,394.271925,23,38,5,394.271925,23,38,5,
                392.256275,23,36,5,414.334525,24,46,5,428.350175,25,48,5,426.334525,25,46,5,
                424.318875,25,44,5,422.303225,25,42,5,420.287575,25,40,5,418.271925,25,38,5,
                442.365825,26,50,5,456.381475,27,52,5,454.365825,27,50,5,452.350175,27,48,5,
                450.334525,27,46,5,448.318875,27,44,5,446.303225,27,42,5,444.287575,27,40,5,
                470.397125,28,54,5,484.412775,29,56,5,482.397125,29,54,5,498.428425,30,58,5,
                512.444075,31,60,5};

        // Multidimensional Array ???
        double[][][] gMassArray = new double[49][44][44];
        gMassArray [0][0][0] = 134.057910;
        gMassArray [1][0][0] = 162.089210;
        gMassArray [3][0][0] = 190.120510;

        setMass(arrayGlycerolipid_sn1[g_sn1Index * 4]);
        setNumC((int)arrayGlycerolipid_sn1[(g_sn1Index * 3) + 1]);
        setNumH((int)arrayGlycerolipid_sn1[(g_sn1Index * 3) + 2]);
        setNumO((int)arrayGlycerolipid_sn1[(g_sn1Index * 3) + 3]);
        return getMass();
    }

    double calculateGPHBasicMass(int g_sn2Index)
    {
        double[] arrayGlycerophospholipid_sn2 = {
                299.113392,10,22,7,341.123957,12,24,369.155257,14,28,
                397.150172,15,28,9,397.186557,16,32,425.217857,18,36,
                453.212772,19,36,9,453.249157,20,40,481.280457,22,44,
                495.296107,23,46,509.311757,24,48,507.296107,24,46,
                523.327407,25,50,521.311757,25,48,537.343057,26,52,
                535.327407,26,50,551.358707,27,54
                ,549.343057,27,52,547.327407,27,50,565.374357,28,56,563.358707,28,54,563.358707,28,54,561.343057,28,52
                ,559.327407,28,50,559.327407,28,50,557.311757,28,48,579.390007,29,58,593.405657,30,60,591.390007,30,58
                ,589.374357,30,56,587.358707,30,54,585.343057,30,52,583.327407,30,50,607.421307,31,62,621.436957,32,64
                ,619.421307,32,62,617.405657,32,60,615.390007,32,58,613.374357,32,56,611.358707,32,54,609.343057,32,52
                ,635.452607,33,66,649.468257,34,68,647.452607,34,66,663.483907,35,70,677.499557,36,327.144692,12,26,7
                ,369.155257,14,28,397.186557,16,32,425.181472,17,32,9,425.217857,18,36,453.249157,20,40,481.244072,21,40,9,
                481.280457,22,44,509.311757,24,48,523.327407,25,50,537.343057,26,52,535.327407,26,50,551.358707,27,54,
                549.343057,27,52,565.374357,28,56,563.358707,28,54,579.390007,29,58,577.374357,29,56
                ,575.358707,29,54,593.405657,30,60,591.390007,30,58,591.390007,30,58,589.374357,30,56,587.358707,30,54
                ,587.358707,30,54,585.343057,30,52,607.421307,31,62,621.436957,32,64,619.421307,32,62,617.405657,32,60
                ,615.390007,32,58,613.374357,32,56,611.358707,32,54,635.452607,33,66,649.468257,34,68,647.452607,34,66
                ,645.436957,34,64,643.421307,34,62,641.405657,34,60,639.390007,34,58,637.374357,34,56,663.483907,35,70
                ,677.499557,36,72,675.483907,36,70,691.515207,37,74,705.530857,38,76,355.175992,14,30,7,397.186557,16,32
                ,425.217857,18,36,453.212772,19,36,9,453.249157,20,40,481.280457,22,44,509.275372,23,44,9,509.311757,24,48
                ,537.343057,26,52,551.358707,27,54,565.374357,28,56,563.358707,28,54,579.390007,29,58,577.374357,29,56
                ,593.405657,30,60,591.390007,30,58,607.421307,31,62,605.405657,31,60,603.390007,31,58,621.436957,32,64
                ,619.421307,32,62,619.421307,32,62,617.405657,32,60,615.390007,32,58,615.390007,32,58,613.374357,32,56
                ,635.452607,33,66,649.468257,34,68,647.452607,34,66,645.436957,34,64,643.421307,34,62,641.405657,34,60
                ,639.390007,34,58,663.483907,35,70,677.499557,36,72,675.483907,36,70,673.468257,36,68,671.452607,36,66
                ,669.436957,36,64,667.421307,36,62,665.405657,36,60,691.515207,37,74,705.530857,38,76,703.515207,38,74
                ,719.546507,39,78,733.562157,40,80,383.207292,16,34,425.217857,18,36,453.249157,20,40,481.244072,21,40
                ,481.280457,22,44,509.311757,24,48,537.306672,25,48,537.343057,26,52
                ,565.374357,28,56,579.390007,29,58,593.405657,30,60,591.390007,30,58
                ,607.421307,31,62,605.405657,31,60,621.436957,32,64,619.421307,32,62
                ,635.452607,33,66,633.436957,33,64,631.421307,33,62,649.468257,34,68
                ,647.452607,34,66,647.452607,34,66,645.436957,34,64,643.421307,34,62
                ,643.421307,34,62,641.405657,34,60,663.483907,35,70,677.499557,36,72
                ,675.483907,36,70,673.468257,36,68,671.452607,36,66,669.436957,36,64
                ,667.421307,36,62,691.515207,37,74,705.530857,38,76,703.515207,38,74
                ,701.499557,38,72,699.483907,38,70,697.468257,38,68,695.452607,38,66
                ,693.436957,38,64,719.546507,39,78,733.562157,40,80,731.546507,40,78
                ,747.577807,41,82,761.593457,42,84,411.238592,18,38,453.249157,20,40
                ,481.280457,22,44,509.275372,23,44,509.311757,24,48,537.343057,26,52
                ,565.337972,27,52,565.374357,28,56,593.405657,30,60,607.421307,31,62
                ,621.436957,32,64,619.421307,32,62,635.452607,33,66,633.436957,33,64
                ,649.468257,34,68,647.452607,34,66,663.483907,35,70,661.468257,35,68
                ,659.452607,35,66,677.499557,36,72,675.483907,36,70,675.483907,36,70
                ,673.468257,36,68,671.452607,36,66,671.452607,36,66,669.436957,36,64
                ,691.515207,37,74,705.530857,38,76,703.515207,38,74,701.499557,38,72
                ,699.483907,38,70,697.468257,38,68,695.452607,38,66,719.546507,39,78
                ,733.562157,40,80,731.546507,40,78,729.530857,40,76,727.515207,40,74
                ,725.499557,40,72,723.483907,40,70,721.468257,40,68,747.577807,41,82
                ,761.593457,42,84,759.577807,42,82,775.609107,43,86,789.624757,44,88
        };
        setMass(arrayGlycerophospholipid_sn2[g_sn2Index * 4]);
        setNumC((int)arrayGlycerophospholipid_sn2[(g_sn2Index * 3) + 1]);
        setNumH((int)arrayGlycerophospholipid_sn2[(g_sn2Index * 3) + 2]);
        setNumO((int)arrayGlycerophospholipid_sn2[(g_sn2Index * 3) + 3]);
        setNumN(1);
        setNumP(1);
        return getMass();
    }
    double calculateFinalMass(int ion, double basicMass)
    {
        if(ion == 0){basicMass+= 1.00727; setNumH(getNumH()+1);}
        else if(ion == 1){basicMass+= 1.00727 -(18.010565) ; setNumH(getNumH()-1); setNumO(getNumO()-1);}
        else if(ion == 2){basicMass = (2*(1.00727)+ basicMass)/2; setNumH(getNumH()+2);}
        else if(ion == 3){basicMass = (3*(1.00727)+ basicMass)/3; setNumH(getNumH()+3);}
        else if(ion == 4){basicMass = (4*(1.00727)+ basicMass)/4; setNumH(getNumH()+4);}
        else if(ion == 5){basicMass = 38.963708 - 0.000555 + basicMass; setNumK(getNumK()+1);}
        else if(ion == 6){basicMass = (2*(38.963708 - 0.000555) + basicMass)/2;  setNumK(getNumK()+2);}
        else if(ion == 7){basicMass = (2*(38.963708) - 0.000555 -1.007825) + basicMass; setNumK(getNumK()+2); setNumH(getNumH()-1);}
        else if(ion == 8){basicMass = 22.98977 - 0.000555 + basicMass; setNumNa(getNumNa()+1);}
        else if(ion == 9){basicMass = (2*(22.98977 - 0.000555) + basicMass)/2; setNumNa(getNumNa()+2);}
        else if(ion == 10){basicMass = (2*(22.98977) - 0.000555 -1.007825) + basicMass; setNumNa(getNumNa()+2); setNumH(getNumH()-1);}
        else if(ion == 11){basicMass = 7.016005  -0.000555 + basicMass; setNumLi(getNumLi()+1);}
        else if(ion == 12){basicMass = (2*(7.016005  -0.000555) + basicMass)/2; setNumLi(getNumLi()+2);}
        else if(ion == 13){basicMass = 106.905095 - 0.000555 + basicMass; setNumAg(getNumAg()+1);}
        else if(ion == 14){basicMass = (3*1.007825) + 1.00727 + 14.003074 + basicMass; setNumH(getNumH()+4);  setNumN(getNumN()+1);}
        else if(ion == 15){basicMass-= 1.00727; setNumH(getNumH()-1);}
        else if(ion == 16){basicMass = (-1.00727-(2*1.007825)-12) + basicMass; setNumH(getNumH()-3); setNumC(getNumC()-1);}
        else if(ion == 17){basicMass = (2*(-1.00727)+ basicMass)/2; setNumH(getNumH()-2);}
        else if(ion == 18){basicMass = (3*(-1.00727)+ basicMass)/3; setNumH(getNumH()-3);}
        else if(ion == 19){basicMass = (4*(-1.00727)+ basicMass)/4; setNumH(getNumH()-4);}
        else if(ion == 20){basicMass = 34.968853 + 0.000555 + basicMass;  setNumCl(getNumCl()+1);}
        else if(ion == 21){basicMass = 59.013305 + 0.000555 + basicMass;  setNumC(getNumC()+2);  setNumH(getNumH()+3);  setNumO(getNumO()+2);}
        else if(ion == 22){basicMass = 44.997655 + 0.000555 + basicMass;  setNumC(getNumC()+1);  setNumH(getNumH()+1);  setNumO(getNumO()+2);}
        return basicMass;
    }

    private double getMass() {
        return mass;
    }

    int getNumC() {
        return numC;
    }

    int getNumH() {
        return numH;
    }

    int getNumN() {
        return numN;
    }

    int getNumO() {
        return numO;
    }

    int getNumAg() {
        return numAg;
    }

    int getNumLi() {
        return numLi;
    }

    int getNumNa() {
        return numNa;
    }

    int getNumK() {
        return numK;
    }

    int getNumCl() {
        return numCl;
    }

    int getNumP() {
        return numP;
    }

    int getNumS() {
        return numS;
    }

    int getNumF() {
        return numF;
    }

    private void setMass(double mass) {
        this.mass = mass;
    }

    private void setNumC(int numC) {
        this.numC = numC;
    }

    private void setNumH(int numH) {
        this.numH = numH;
    }

    private void setNumN(int numN) {
        this.numN = numN;
    }

    private void setNumO(int numO) {
        this.numO = numO;
    }

    private void setNumAg(int numAg) {
        this.numAg = numAg;
    }

    private void setNumLi(int numLi) {
        this.numLi = numLi;
    }

    private void setNumNa(int numNa) {
        this.numNa = numNa;
    }

    private void setNumK(int numK) {
        this.numK = numK;
    }

    private void setNumCl(int numCl) {
        this.numCl = numCl;
    }

    private void setNumP(int numP) {
        this.numP = numP;
    }

    private void setNumS(int numS) {
        this.numS = numS;
    }

    private void setNumF(int numF) {
        this.numF = numF;
    }
}
