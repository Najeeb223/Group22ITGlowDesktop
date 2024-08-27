import Link from 'next/link';
import Logo from '@/uicomponents/dashboard/logo';



export default function Page() {
  return (
    <main className="flex min-h-screen flex-col p-6 bg-[url('/salon.jpg')] bg-cover bg-center">
     
      <div className="flex h-20 shrink-0 items-end rounded-lg bg-pink-500 p-4 md:h-52">
      <Logo/> 
      </div>
      <div className="mt-4 flex grow flex-col gap-4 md:flex-row">
      <div className="flex flex-col justify-center gap-6 rounded-lg bg-pink-200 px-6 py-10 md:w-2/5 md:px-20">
      <div className="relative w-0 h-0 border-l-[15px] border-r-[15px] border-b-[26px] border-l-transparent border-r-transparent border-b-black"/>
          
          <p className={` text-xl text-gray-800 md:text-3xl md:leading-normal`}>
            <strong>Welcome to ITGLOW , where style meets innovation.</strong>
          </p>
          <Link
            href="/login"
            className="flex items-center gap-5 self-start rounded-lg bg-pink-500 px-6 py-3 text-sm font-medium text-white transition-colors hover:bg-blue-400 md:text-base"
          >
            <span>Log in</span> 
          </Link>
        </div>
        <div className="flex items-center justify-center p-6 md:w-3/5 md:px-28 md:py-12">
       
        </div>
      </div>
    </main>
  );
}