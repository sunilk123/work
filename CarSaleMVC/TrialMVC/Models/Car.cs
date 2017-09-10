namespace TrialMVC.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;
    using System.Web;

    public partial class Car
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int CarId { get; set; }

        [Required]
        [StringLength(10)]
        public string CarMake { get; set; }

        [StringLength(10)]
        public string CarName { get; set; }

        public int? Mileage { get; set; }

        [StringLength(10)]
        public string Color { get; set; }

        public int? CarModel { get; set; }

        public int? Cost { get; set; }

        [Column(TypeName = "image")]
        public byte[] Photo { get; set; }

        public int? CustomerId { get; set; }

        public virtual LoginTable LoginTable { get; set; }
        [NotMapped]
        public HttpPostedFileBase img { get; set; }

    }
}
