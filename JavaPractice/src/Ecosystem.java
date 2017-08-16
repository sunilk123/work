/**
 * Created by SUNIL PC on 18-07-2017.
 */
public class Ecosystem {

    public void content(){
        System.out.println("Ecosystem has Commmunity");
    }

    public class Community{

        public void content(){
            System.out.println("Community has Population");
        }

        public class Population{

            public void content(){
                System.out.println("Population has Organism");
            }

            public class Organism{

                public void content(){
                    System.out.println("Organism has organ system");
                }

                public class OrganSystem{

                    public void content(){
                        System.out.println("OrganSystem has Organs");
                    }

                    public class Organ{

                        public void content(){
                            System.out.println("Organ has tissues");
                        }

                        public class Tissue{

                            public void content(){
                                System.out.println("Tisuue has Cells");
                            }

                            public class Cell{

                                public void content(){
                                    System.out.println("Cell is the basic unit of ecosystem");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
