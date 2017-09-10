namespace TrialMVC.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using Models;

    public partial class AutoLotEntities : DbContext
    {
        public AutoLotEntities()
            : base("name=AutoLotConnection")
        {
        }

        public virtual DbSet<Car> Cars { get; set; }
        public virtual DbSet<LoginTable> LoginTables { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Car>()
                .Property(e => e.CarMake)
                .IsFixedLength();

            modelBuilder.Entity<Car>()
                .Property(e => e.CarName)
                .IsFixedLength();

            modelBuilder.Entity<Car>()
                .Property(e => e.Color)
                .IsFixedLength();

            modelBuilder.Entity<LoginTable>()
                .Property(e => e.CustomerPwd)
                .IsFixedLength();

            modelBuilder.Entity<LoginTable>()
                .Property(e => e.Role)
                .IsFixedLength();
        }
    }
}
