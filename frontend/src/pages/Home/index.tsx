import axios from "axios";
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import Footer from "../../components/Footer";
import NavBar from "../../components/NavBar";
import { Clima } from 'types/clima';

const Home = () => {

    navigator.geolocation.getCurrentPosition(showPosition);

    let latp = "";
    let longp = "";

    function showPosition(position: any) {
        const lat = position.coords.latitude;
        const long = position.coords.longitude;
        latp = lat;
        longp = long;
    }

    let precipitacao = 0;
    let ventania = 0;

    const [page, setPage] = useState<Clima>();

    useEffect(() => {
        axios.get(`${BASE_URL}/clima/${latp},${longp}`)
            .then((response) => {
                console.log(response.data);

                precipitacao = response.data.current.precip_mm;
                ventania = response.data.current.precip_mm;

                setPage(response.data);


            });
    });

    return (
        <>
            <NavBar />
            <div className="table-responsive padding">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th className="text-secondary">Informações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Temperatura</td>
                            <td>{page?.current.temp_c}</td>
                        </tr>
                        <tr>
                            <td>Precipitação</td>
                            <td>{page?.current.precip_mm}</td>

                        </tr>
                        <tr>
                            <td>Velocidade do Vento</td>
                            <td>{page?.current.wind_kph}</td>
                        </tr>
                        <tr>
                            <td>Nome do local</td>
                            <td>{page?.location?.name}</td>
                        </tr>
                        <tr>
                            <td>Região</td>
                            <td>{page?.location?.region}</td>
                        </tr>
                        <tr>
                            <td>Latitude</td>
                            <td>{page?.location?.lat}</td>
                        </tr>
                        <tr>
                            <td>Longitude</td>
                            <td>{page?.location?.lon}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div className="padding">
                {precipitacao > 25 &&
                    <div className="text-third">
                        Alerta - Risco de Enchente e Alagamentos
                    </div>
                }
                {ventania > 14 &&
                    <div className="text-third">
                        Alerta - Risco de Ventania
                    </div>
                }
                {ventania < 14 && precipitacao < 25 && 
                    <div className="text-secondary">
                        Sem  riscos de Ventania, Enchente e Alagamentos
                    </div>
                }
            </div>
            <Footer />
        </>
    );
}

export default Home;