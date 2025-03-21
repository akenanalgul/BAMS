const Services = () => {
    return (
      <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-6">
        <h1 className="text-3xl font-bold text-gray-900">Hizmetlerimiz</h1>
        <div className="mt-6 space-y-4 max-w-3xl">
          <div className="bg-white p-4 shadow-lg rounded-lg">
            <h2 className="text-xl font-semibold text-blue-600">Bireysel Krediler</h2>
            <p className="text-gray-700">İhtiyaç, taşıt ve konut kredileri ile hayallerinize ulaşın.</p>
          </div>
          <div className="bg-white p-4 shadow-lg rounded-lg">
            <h2 className="text-xl font-semibold text-blue-600">Yatırım Danışmanlığı</h2>
            <p className="text-gray-700">Profesyonel finansal danışmanlık ile yatırımınızı güvenle yönetin.</p>
          </div>
          <div className="bg-white p-4 shadow-lg rounded-lg">
            <h2 className="text-xl font-semibold text-blue-600">Dijital Bankacılık</h2>
            <p className="text-gray-700">İnternet ve mobil bankacılık ile 7/24 işlemlerinizi gerçekleştirin.</p>
          </div>
        </div>
      </div>
    );
  };
  
  export default Services;
  